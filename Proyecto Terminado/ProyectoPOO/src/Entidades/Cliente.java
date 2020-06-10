/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Mario Mendoza
 */
public class Cliente {
    String ID;
    String Nombre;
    String DUI;
    Date fecha;
    double total;
    public ArrayList<Producto> lPedido;
    public Cliente(String id ,String nombre,String dui, Date fecha, double total) {
        this.ID= id;
        this.Nombre = nombre;
        this.DUI= dui;
        this.fecha = fecha;
        this.total= total;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
        
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Producto> getlPedido() {
        return lPedido;
    }

    public void setlPedido(ArrayList<Producto> lPedido) {
        this.lPedido = lPedido;
    }
    

   
    
}
