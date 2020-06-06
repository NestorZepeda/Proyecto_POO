/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Mario Mendoza
 */
public interface Funciones {

    public double SubTotal(double Cantidad, double precio);
    public double Total(double cantidad, double precio, double TT);
    public double iva(double precio);

}