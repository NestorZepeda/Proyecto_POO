/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseDocumentos;

import Formularios.Venta;
import java.awt.Font;
import java.io.File;
import FrameLectorPDF.*;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;


/**
 *
 * @author Nestor
 */
public class PDF {
    
    public void Crear()
    {
        MsjError me = new MsjError();
        Venta v= new Venta();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser);
        File selectedFile=null;
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = fileChooser.getSelectedFile();
        }
             Document doc = new Document();
	 try 
	 {
             
             PdfWriter.getInstance(doc, new FileOutputStream(selectedFile));
             
             doc.open();
                Paragraph titulo = new Paragraph("Lista de Clientes \n\n",
                                        FontFactory.getFont("Times New Roman",32,Font.BOLD,BaseColor.BLACK));
                doc.add(titulo);
               
                 for (int i = 0; i <v.lClie.size(); i++) 
                 {
                        PdfPTable table = new PdfPTable(4);
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("\n"));
                    
                     doc.add(new Paragraph("ID del Cliente: "+v.lClie.get(i).getID()));
                     doc.add(new Paragraph("\n"));
                      doc.add(new Paragraph("Nombre del Cliente: "+v.lClie.get(i).getNombre()));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("N° DUI: "+v.lClie.get(i).getDUI()));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("Fecha de Compra: "+v.lClie.get(i).getFecha()));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("Total: "+String.valueOf(v.lClie.get(i).getTotal())));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("\n"));
                     doc.add(new Paragraph("\n"));
                     table.addCell("ID Producto");
                     table.addCell("Producto");
                     table.addCell("cantidad");
                     table.addCell("precio");
                     table.addCell("subtotal");
                     for (int j = 0; j < v.lClie.get(i).lPedido.size(); j++) 
                     {
                         
                            table.addCell(v.lClie.get(i).lPedido.get(j).id);
                            table.addCell(v.lClie.get(i).lPedido.get(j).produc);
                            table.addCell(Integer.toString(v.lClie.get(i).lPedido.get(j).cantidad));
                            table.addCell(Double.toString(v.lClie.get(i).lPedido.get(j).precio));
                            table.addCell(Double.toString(v.lClie.get(i).lPedido.get(j).subtotal));

                     }
                     
                     doc.add(table);
                 }
    
         }
         catch(DocumentException | FileNotFoundException e)
         {
             me.ErrorCrear();
         }
         
         doc.close();
         me.Archvioguardado();
    }
         
    public void Abrir()
    {
        new Visual().setVisible(true);
        
    }
       
}
