/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseDocumentos;

import Entidades.Inventario;
import Formularios.Inicio;
import Formularios.Venta;
import java.awt.HeadlessException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Nestor
 */
public class CSV {
    
    public void Crear() throws IOException
    {
        
         MsjError me = new MsjError();
         PrintWriter pw = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(fileChooser);
        File selectedFile=null;
        if (result==JFileChooser.CANCEL_OPTION) {
            me.msjCancelado();
        }
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            selectedFile = fileChooser.getSelectedFile();
        } 
        if (!selectedFile.exists()) {
            selectedFile.createNewFile();
        }
        else
        {
            me.ArchivoExistente();
        }
        try 
        {
         pw = new PrintWriter(new File(selectedFile.getAbsolutePath()));
        
        }catch (HeadlessException | FileNotFoundException e) 
        {
           me.Error();
        }
        try{
         StringBuilder strLinea = new StringBuilder();
        
         String ColumnNamesList = "ID,Nombre Producto, Existencia,Costo,Precio Venta";

         strLinea.append(ColumnNamesList +"\n");
        for (int i = 0; i < Inicio.lInv.size(); i++) 
        {
             strLinea.append(Inicio.lInv.get(i).getIdprod()+","+
                             Inicio.lInv.get(i).getProducName()+","+
                             Inicio.lInv.get(i).getExistencias()+","+
                             Inicio.lInv.get(i).getCostoProd()+","+
                             Inicio.lInv.get(i).getPrecioVenta()+","+"\n"
                             );
            
        }
        
        pw.write(strLinea.toString());
        pw.close(); 
        me.Archvioguardado();
          Venta v= new Venta();
          v.setVisible(true);
        }catch(HeadlessException e){}
      
    }
    
    
    public void Modificar() throws IOException
    
    {
         MsjError me = new MsjError();
         FileWriter fw = null;
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
         int result = fileChooser.showOpenDialog(fileChooser);
         File selectedFile=null;
         if (result==JFileChooser.CANCEL_OPTION) {
            me.msjCancelado();
         }
         if (result == JFileChooser.APPROVE_OPTION) 
         {
             selectedFile = fileChooser.getSelectedFile();
         } 
         
         fw = new FileWriter(selectedFile);
         BufferedWriter bfwriter = new BufferedWriter(fw);
         bfwriter.write( "ID,Nombre Producto, Existencia,Costo,Precio Venta"+"\n");
         for (int i = 0; i < Inicio.lInv.size(); i++) 
            {
                 bfwriter.write(Inicio.lInv.get(i).getIdprod()+","+
                                Inicio.lInv.get(i).getProducName()+","+
                                Inicio.lInv.get(i).getExistencias()+","+
                                Inicio.lInv.get(i).getCostoProd()+","+
                                Inicio.lInv.get(i).getPrecioVenta()+","+"\n"
                             );
            
           }
        
        bfwriter.close(); 
        me.Archvioguardado();
        
        
        
         
    }
    
    public void Abrir() 
    {   
         
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
            Scanner scan = new Scanner(new File(selectedFile.getAbsolutePath()));
            scan.nextLine();//funciona cuando hay encabezado
            while (scan.hasNextLine()) 
            {
                String sLinea = scan.nextLine();
                String[] aEle = sLinea.split(",");
                Inventario iTemp=new Inventario(Integer.parseInt(aEle[0]),aEle[1].trim(),
                                                Integer.parseInt(aEle[2]),
                                                Double.parseDouble(aEle[3]),
                                                Double.parseDouble(aEle[4]));
                Inicio.lInv.add(iTemp);
            }
     
        }
            catch (FileNotFoundException | NumberFormatException e){}
    
             Venta v= new Venta();
             v.setVisible(true);
    }

}
