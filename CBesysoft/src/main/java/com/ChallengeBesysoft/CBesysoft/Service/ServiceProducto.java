package com.ChallengeBesysoft.CBesysoft.Service;


import com.ChallengeBesysoft.CBesysoft.models.Productos;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServiceProducto {


    Scanner leer = new Scanner(System.in);
    boolean bandera;
    public void altaProducto(List<Productos> listaDeProductos ){

        Productos p1 = new Productos();
        do {
            try {
                System.out.println("Ingrese el codigo del producto");
                bandera = false;
                p1.setCodigo(leer.nextLong());
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);

        leer.nextLine();

        String nombre = "";
        while (nombre.equals("")){
            System.out.println("Ingrese el nombre del producto");

            nombre = leer.next().toLowerCase();
            if (!nombre.matches("^[A-Za-z ]*$")){
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba caracteres");
                nombre="";
            }else{
                p1.setNombre(nombre);
            }
        }

        do {
            try {
                System.out.println("Ingrese el precio del producto");
                bandera = false;
                p1.setPrecio(leer.nextDouble());
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);

        leer.nextLine();

        nombre="";
        while (nombre.equals("")){
            System.out.println("Ingrese la categoria");

            nombre = leer.next().toLowerCase();
            if (!nombre.matches("^[A-Za-z ]*$")){
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba caracteres");
                nombre="";
            }else{
                p1.setCategoria(nombre);
            }
        }
        listaDeProductos.add(p1);
        System.out.println("El poducto se a creado exitosamente");
        System.out.println(listaDeProductos);

    }

    public Productos buscarProductoCodigo(int codigo,List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> productos.getCodigo()==codigo).findAny().orElse(null);
    }

    public List<Productos> buscarTodosLosProductosCategoria(String categoria, List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> Objects.equals(productos.getCategoria(), categoria.toLowerCase())).collect(Collectors.toList());
    }
    public List<Productos> buscarTodosLosProductosPrecioMayor(double precio, List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> productos.getPrecio()>precio ).collect(Collectors.toList());
    }
    public List<Productos> buscarTodosLosProductosPrecioMenor(double precio, List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> productos.getPrecio()<precio ).collect(Collectors.toList());
    }
}
