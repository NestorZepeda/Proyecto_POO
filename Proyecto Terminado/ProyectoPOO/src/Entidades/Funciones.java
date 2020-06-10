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

    public double SubTotal(int Cantidad, double precio);
    public double Total(double subt, double TT);
    public double iva(double precio);

}