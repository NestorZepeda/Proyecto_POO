package mivisorpdf;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class CuadroImagen
        extends JPanel
        implements Printable {

    private float zoom;
    public static int ancho;
    public static int alto;
    private BufferedImage bufferImagen;
    private Image imagen;
    private Image imagenAux;
    private boolean hayFoto = false;

    public CuadroImagen() {
        this.zoom = 0.0F;
        setBounds(0, 0, 595, 842);
        setVisible(true);
    }

    public void setImagen(byte[] vi) {
        this.zoom = 0.0F;
        try {
            //ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(vi));
            ByteArrayInputStream in = new ByteArrayInputStream(vi);
            this.bufferImagen = ImageIO.read(in);
            this.imagen = this.bufferImagen;
            this.imagenAux = this.imagen;
            this.hayFoto = true;

            this.ancho = this.imagen.getWidth(this);
            this.alto = this.imagen.getHeight(this);
            resize();
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.hayFoto) {
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.translate(getWidth() / 2, getHeight() / 2);
            g2d.translate(-this.ancho / 2, -this.alto / 2);
            g2d.drawImage(this.imagenAux, 0, 0, this.ancho, this.alto, this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
        super.paintComponent(g2d);
    }

    public void aumentar() {
        this.zoom = ((float) (this.zoom + 0.1D));

        this.ancho = ((int) (this.imagen.getWidth(this) * (this.zoom + 1.0F)));
        this.alto = ((int) (this.imagen.getHeight(this) * (this.zoom + 1.0F)));
        this.imagenAux = this.imagen.getScaledInstance(this.ancho, this.alto, 16);
        resize();
        repaint();
    }

    public void disminuir() {
        this.zoom = ((float) (this.zoom - 0.1D));
        this.ancho = ((int) (this.imagen.getWidth(this) * (this.zoom + 1.0F)));
        this.alto = ((int) (this.imagen.getHeight(this) * (this.zoom + 1.0F)));
        this.imagenAux = this.imagen.getScaledInstance(this.ancho, this.alto, 16);
        resize();
        repaint();
    }

    public void resize() {
        setPreferredSize(new Dimension(this.ancho, this.alto));
        resize(this.ancho, this.alto);
    }

    public int print(Graphics g, PageFormat pf, int indexPage)
            throws PrinterException {
        if (indexPage == 0) {
            g.clearRect(0, 0, getWidth(), getHeight());
            g.drawImage(this.imagen, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), this);
            return 0;
        }
        return 1;
    }

    public void imprimir() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        PageFormat pageFormat = new PageFormat();
        pageFormat = job.pageDialog(pageFormat);
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
