/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseDocumentos;

import java.awt.Font;
import java.io.File;
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
               
                 for (int i = 0; i < 1; i++) 
                 {}
    
    }
         catch(DocumentException | FileNotFoundException e){}
         
         
    }
    
    public void Abrir()
    {
    
    }
    
    public void  Error()
    {
    
    }
    
}
