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
public abstract class Productos {
    private int Idprod;
    private String producName;
    private int existencias;
    private double costoProd;
    private double precioVenta;

    public Productos(int Idprod, String producName, int existencias, double costoProd, double precioVenta) {
        this.Idprod = Idprod;
        this.producName = producName;
        this.existencias = existencias;
        this.costoProd = costoProd;
        this.precioVenta = precioVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdprod() {
        return Idprod;
    }

    public void setIdprod(int Idprod) {
        this.Idprod = Idprod;
    }

    public String getProducName() {
        return producName;
    }

    public void setProducName(String producName) {
        this.producName = producName;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getCostoProd() {
        return costoProd;
    }

    public void setCostoProd(double costoProd) {
        this.costoProd = costoProd;
    }
    

}
