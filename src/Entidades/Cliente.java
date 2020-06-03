/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Mario Mendoza
 */
public abstract class Cliente implements CalcPrecio {

    String Nombre;
    String DUI;
    String producto;
    int cantidad;
    double precio;
    double CalcprecioProd;
    double total;

    public Cliente(String producto, int cantidad, double precio, double CalcprecioProd) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.CalcprecioProd = CalcprecioProd;
    }

    @Override
    public double Tprecio(double Cantidad, double precio) {
        return Cantidad * precio;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCalcprecioProd() {
        return CalcprecioProd;
    }

    public void setCalcprecioProd(double CalcprecioProd) {
        this.CalcprecioProd = CalcprecioProd;
    }

}
