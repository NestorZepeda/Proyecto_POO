/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mivisorpdf;

import VO.ArchivosVO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

/**
 *
 * @author Mario
 */
public class MiVisorPDF {

    /**
     * @param args the command line arguments
     */
    // 1. pagina1
    // 2. pagina2
    /**/
    public ArrayList<ArchivosVO> leerPDF(String rutaPDF) {
        File file = new File(rutaPDF);
        byte[] bi = null;
        ArrayList<ArchivosVO> ar = new ArrayList<ArchivosVO>();
        try {
            RandomAccessFile raf = new RandomAccessFile(file, "r");
            //ReadableByteChannel ch = Channels.newChannel(new FileInputStream(file));
            FileChannel channel = raf.getChannel();
            ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            PDFFile pdffile = new PDFFile(buf);
            //   get number of pages
            int numpag = pdffile.getNumPages();
            //  iterate through the number of pages
            //----------------------
            ByteArrayOutputStream baos = null;
            for (int i = 1; i <= numpag; i++) {
                PDFPage page = pdffile.getPage(i);
                //  create new image
                Rectangle rect = new Rectangle(0, 0,
                        (int) page.getBBox().getWidth(),
                        (int) page.getBBox().getHeight());
                Image img = page.getImage(
                        rect.width * 2, rect.height * 2, //width & height
                        rect, // clip rect
                        null, // null for the ImageObserver
                        true, // fill background with white
                        true // block until drawing is done
                );

                BufferedImage bufferedImage = new BufferedImage(rect.width * 2, rect.height * 2, BufferedImage.TYPE_INT_RGB);
                Graphics g = bufferedImage.createGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();

                baos = new ByteArrayOutputStream();
                //ImageIO.write(bufferedImage, "jpg", Base64.getEncoder().wrap(baos));
                //---------------------------------------

                //---------------------------------------
                ImageIO.write(bufferedImage, "PNG", baos);
                bi = baos.toByteArray();

                ArchivosVO po = new ArchivosVO();
                po.setIdArchivos(i);
                po.setArchivos(bi);
                ar.add(po);
                //-----

            }
            baos.close();
            buf.clear();
            channel.close();
            raf.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ar;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
