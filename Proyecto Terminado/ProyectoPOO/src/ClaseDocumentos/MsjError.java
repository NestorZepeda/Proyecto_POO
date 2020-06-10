/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseDocumentos;

import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Nestor
 */
public class MsjError extends CSV{
    public void  Error()
    {
         Icon icono= new ImageIcon("src\\imagenes\\iconE.png");
         JOptionPane.showMessageDialog(null,"No se pudo cargar el archivo","Error",JOptionPane.PLAIN_MESSAGE,icono);
    }
     public void  ErrorCrear()
    {
         Icon icono= new ImageIcon("src\\imagenes\\iconE.png");
         JOptionPane.showMessageDialog(null,"No se pudo crear el archivo","Error",JOptionPane.PLAIN_MESSAGE,icono);
    }
     
      public void Archvioguardado()
    {
        Icon icono= new ImageIcon("src\\imagenes\\check.png");
        JOptionPane.showMessageDialog(null,"El archivo se ha guardado correctamente","Archivo Guardado",JOptionPane.PLAIN_MESSAGE,icono);
    }
      
      public void ArchivoExistente() throws IOException
      
      {
              String botones []={"Continuar","Cancelar"};
             Icon icono= new ImageIcon("src\\imagenes\\shuffle.png");
           int eleccion= JOptionPane.showOptionDialog(null,"¿Desea reemplazarlo?", "Ya existe el archivo",0 ,0, icono, botones, null);
            if (eleccion==JOptionPane.YES_OPTION) {
               
            }else if (eleccion==JOptionPane.NO_OPTION) {
              icono= new ImageIcon("src\\imagenes\\iconE.png");
             JOptionPane.showMessageDialog(null,"Seleccione otro nombre para el archivo ","Cancelado",JOptionPane.PLAIN_MESSAGE,icono);
              Crear();
            }
      }
      
      public void msjCancelado()
      
      {
            Icon icono= new ImageIcon("src\\imagenes\\iconE.png");
         JOptionPane.showMessageDialog(null,"No se pudo crear el archivo","Cancelado",JOptionPane.PLAIN_MESSAGE,icono); 
        
      }
      
      
}
