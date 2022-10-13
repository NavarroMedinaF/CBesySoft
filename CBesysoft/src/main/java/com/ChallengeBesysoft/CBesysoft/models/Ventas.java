package com.ChallengeBesysoft.CBesysoft.models;


public class Ventas {

    private long numeroVenta;


    private Productos producto;


    private Vendedor vendedor;

    /*CONTRUCTOR*/

    public Ventas() {
    }

    public Ventas(long numeroVenta, Productos ventasProducto, Vendedor ventasVendedor) {
        this.numeroVenta = numeroVenta;
        this.producto = ventasProducto;
        this.vendedor = ventasVendedor;
    }

    /*GETTERS*/

    public long getNumeroVenta() {
        return numeroVenta;
    }

    public Productos getProducto() {
        return producto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    /*SETTERS*/

    public void setNumeroVenta(long numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Ventas{" +
                "numeroVenta=" + numeroVenta +
                ", ventasProducto=" + producto +
                ", ventasVendedor=" + vendedor +
                '}';
    }
}
