package com.ChallengeBesysoft.CBesysoft.Service;

import com.ChallengeBesysoft.CBesysoft.models.Productos;
import com.ChallengeBesysoft.CBesysoft.models.Vendedor;
import com.ChallengeBesysoft.CBesysoft.models.Ventas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServiceVenta {

    Scanner leer = new Scanner(System.in);
    ServiceProducto sp = new ServiceProducto();
    ServiceVendedor sv = new ServiceVendedor();


    public void crearVentas(List<Vendedor> listaDeVendedor,  List<Productos> listaDeProductos,List<Ventas> listaDeVentas ){


        Ventas v1 = new Ventas();
        System.out.println("Ingrese el numero de venta");
        int numeroVenta = leer.nextInt();
        v1.setNumeroVenta(numeroVenta);
        leer.nextLine();

        System.out.println("Ingrese el codigo del vendedor");
        int codigoVendedor = leer.nextInt();
        Vendedor vendedor1 = sv.buscarVendedorCodigo(codigoVendedor, listaDeVendedor);
        v1.setVendedor(vendedor1);

        System.out.println("Ingrese el codigo del producto");
        int codigoProducto = leer.nextInt();
        Productos producto1= sp.buscarProductoCodigo(codigoProducto,listaDeProductos );
        v1.setProducto(producto1);
        leer.nextLine();

        listaDeVentas.add(v1);

        List<Ventas> ventasV1= listaDeVentas.stream().filter(venta -> Objects.equals(venta.getVendedor().getNombre(), vendedor1.getNombre())).collect(Collectors.toList());

        if (ventasV1.size()<3 && ventasV1.size()!=0){
            ventasV1.forEach(venta -> {
                vendedor1.setComision(venta.getProducto().getPrecio()*0.05 + vendedor1.getComision());
            });
            System.out.println("Las comisiones a pagar son " + vendedor1.getComision());
        }else {
            ventasV1.forEach(venta -> {
                vendedor1.setComision(venta.getProducto().getPrecio() * 0.1 + vendedor1.getComision());
            });
            System.out.println("Las comisiones a pagar son " + vendedor1.getComision());
        }

        System.out.println("La venta se ha concretado exitosamente");

        System.out.println(listaDeVentas);
    }

    public Ventas buscarVenta(List<Ventas> listaDeVentas){

        System.out.println("Ingrese el numero de venta que desea localizar");
        int numeroVenta = leer.nextInt();
        leer.nextLine();
        return listaDeVentas.stream().filter(ventas -> ventas.getNumeroVenta()==numeroVenta).findAny().orElse(null);
    }
}
