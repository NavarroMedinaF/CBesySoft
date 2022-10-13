package com.ChallengeBesysoft.CBesysoft.Service;


import com.ChallengeBesysoft.CBesysoft.models.Productos;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ServiceProducto {


    Scanner leer = new Scanner(System.in);

    public void altaProducto(List<Productos> listaDeProductos ){

        Productos p1 = new Productos();



        System.out.println("Ingrese el codigo del producto");
        p1.setCodigo(leer.nextLong());
        leer.nextLine();

        System.out.println("Ingrese el nombre del producto");
        p1.setNombre(leer.nextLine());

        System.out.println("Ingrese el precio del producto");
        p1.setPrecio(leer.nextDouble());
        leer.nextLine();

        System.out.println("Ingrese la categoria");
        p1.setCategoria(leer.nextLine().toLowerCase());

        listaDeProductos.add(p1);
        System.out.println("El poducto se a creado exitosamente");
        System.out.println(listaDeProductos);
        ;
    }

    public Productos buscarProductoCodigo(int codigo,List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> productos.getCodigo()==codigo).findAny().orElse(null);
    }

    public Productos buscarProductoCategoria(String categoria,List<Productos> listaDeProductos){
        return listaDeProductos.stream().filter(productos -> Objects.equals(productos.getCategoria(), categoria.toLowerCase())).findAny().orElse(null);
    }


}
