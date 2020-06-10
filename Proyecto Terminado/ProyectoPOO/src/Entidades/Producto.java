/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Nestor
 */
public class Producto {
     public String id, produc;
     public int cantidad;
     public double precio,subtotal;
   

    public Producto(String id, String produc, int cantidad, double precio, double subtotal) {
        this.id= id;
        this.produc = produc;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal= subtotal;
    }
    
}
