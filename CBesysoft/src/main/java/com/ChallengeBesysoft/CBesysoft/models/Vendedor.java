package com.ChallengeBesysoft.CBesysoft.models;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Vendedor {

    private long codigo;
    private String nombre;
    private double sueldo;
    private double comision;


    /*CONTRUCTOR*/

    public Vendedor() {
    }

    public Vendedor(long codigo, String nombre, double sueldo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;

    }

    /*GETTERS*/

    public long getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public double getComision() {
        return comision;
    }


    /*SETTERS*/

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", comision=" + comision +
                '}';
    }
}
