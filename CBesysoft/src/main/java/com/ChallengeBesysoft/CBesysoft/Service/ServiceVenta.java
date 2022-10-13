package com.ChallengeBesysoft.CBesysoft.Service;

import com.ChallengeBesysoft.CBesysoft.models.Productos;
import com.ChallengeBesysoft.CBesysoft.models.Vendedor;
import com.ChallengeBesysoft.CBesysoft.models.Ventas;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceVenta {

    Scanner leer = new Scanner(System.in);
    ServiceProducto sp = new ServiceProducto();
    ServiceVendedor sv = new ServiceVendedor();
    boolean bandera;

    public void crearVentas(List<Vendedor> listaDeVendedor,  List<Productos> listaDeProductos,List<Ventas> listaDeVentas ) throws InputMismatchException{


        Vendedor vendedor = new Vendedor();
        Ventas v1 = new Ventas();
        do {
            try {
                System.out.println("Ingrese el numero de venta");
                v1.setNumeroVenta(leer.nextLong());
                bandera = false;
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);

        leer.nextLine();
        do {
            try {
                System.out.println("Ingrese el codigo del vendedor");
                int codigoVendedor = leer.nextInt();
                Vendedor vendedor1 = sv.buscarVendedorCodigo(codigoVendedor, listaDeVendedor);
                v1.setVendedor(vendedor1);
                vendedor=vendedor1;
                bandera = false;
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);

        do {
            try {
                System.out.println("Ingrese el codigo del producto");
                int codigoProducto = leer.nextInt();
                Productos producto1= sp.buscarProductoCodigo(codigoProducto,listaDeProductos );
                v1.setProducto(producto1);
                bandera = false;

            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);

        leer.nextLine();

        listaDeVentas.add(v1);

        Vendedor finalVendedor = vendedor;
        List<Ventas> ventasV1= listaDeVentas.stream().filter(venta -> Objects.equals(venta.getVendedor().getNombre(), finalVendedor.getNombre())).collect(Collectors.toList());

        if (ventasV1.size()<3 && ventasV1.size()!=0){
            ventasV1.forEach(venta -> {
                finalVendedor.setComision(venta.getProducto().getPrecio()*0.05 + finalVendedor.getComision());
            });
            System.out.println("Las comisiones a pagar son " + finalVendedor.getComision());
        }else {
            ventasV1.forEach(venta -> {
                finalVendedor.setComision(venta.getProducto().getPrecio() * 0.1 + finalVendedor.getComision());
            });
            System.out.println("Las comisiones a pagar son " + finalVendedor.getComision());
        }

        System.out.println("La venta se ha concretado exitosamente");

        System.out.println(listaDeVentas);
    }

    public Ventas buscarVenta(List<Ventas> listaDeVentas) throws InputMismatchException{
        int numeroVenta = 0;

     do{
        try{
            System.out.println("Ingrese el numero de venta que desea localizar");
            numeroVenta= leer.nextInt();
            leer.nextLine();
            bandera = false;
        }catch (InputMismatchException e) {
            leer.next();
            System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            bandera = true;
        }

     } while (bandera);
        int finalNumeroVenta = numeroVenta;
        return listaDeVentas.stream().filter(ventas -> ventas.getNumeroVenta()== finalNumeroVenta).findAny().orElse(null);
    }
}
