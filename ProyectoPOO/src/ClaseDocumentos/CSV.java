/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseDocumentos;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Nestor
 */
public class CSV {
    
    public void Crear()
    {
         PrintWriter pw = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser);
        File selectedFile=null;
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = fileChooser.getSelectedFile();
        }
        try 
        {
         pw = new PrintWriter(new File(selectedFile.getAbsolutePath()));
        
        }catch (HeadlessException | FileNotFoundException e) 
        {
           Error();
        }
    
    }
    
    public void Abrir()
    {
    
    }
    
    public void  Error()
    {
         Icon icono= new ImageIcon(getClass().getResource("imagenes/iconE.png"));
         JOptionPane.showMessageDialog(null,"No se pudo crear el archivo","",JOptionPane.PLAIN_MESSAGE,icono);
    }
}
