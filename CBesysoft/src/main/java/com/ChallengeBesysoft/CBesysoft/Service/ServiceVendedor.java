package com.ChallengeBesysoft.CBesysoft.Service;
import com.ChallengeBesysoft.CBesysoft.models.Vendedor;
import java.util.List;

import java.util.Scanner;



public class ServiceVendedor {

    Scanner leer = new Scanner(System.in);
    public void altaVendedor(List<Vendedor> listaDeVendedor){



        Vendedor v1= new Vendedor();

        System.out.println("Ingrese el codigo del vendedor");
        v1.setCodigo(leer.nextLong());
        leer.nextLine();

        System.out.println("Ingrese el nombre del vendedor");
        v1.setNombre(leer.nextLine().toLowerCase());


        System.out.println("Ingrese el sueldo del vendedor");
        v1.setSueldo(leer.nextDouble());
        leer.nextLine();

        listaDeVendedor.add(v1);
        System.out.println("El Vendedor se ha creado exitosamente");
        System.out.println(listaDeVendedor);
    }

    public Vendedor buscarVendedorCodigo(int codigo, List<Vendedor> listaDeVendedor){
        return listaDeVendedor.stream().filter(vendedor -> vendedor.getCodigo()==codigo).findAny().orElse(null);
    }

    public void calcularComision(List<Vendedor> listaDeVendedor) {
        System.out.println("Ingrese el codigo del vendedor");
        Vendedor v1 = buscarVendedorCodigo(leer.nextInt(), listaDeVendedor);
        System.out.println(v1.getComision());
   }


}
