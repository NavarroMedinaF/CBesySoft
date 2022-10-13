package com.ChallengeBesysoft.CBesysoft.Service;
import com.ChallengeBesysoft.CBesysoft.models.Vendedor;

import java.util.InputMismatchException;
import java.util.List;

import java.util.Scanner;



public class ServiceVendedor{

    Scanner leer = new Scanner(System.in);
    boolean bandera;
    public void altaVendedor(List<Vendedor> listaDeVendedor) throws InputMismatchException {
        Scanner leer = new Scanner(System.in);
        Vendedor v1= new Vendedor();
        do {
            try {
                System.out.println("Ingrese el codigo del vendedor");
                bandera = false;
                v1.setCodigo(leer.nextLong());
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
       } while (bandera);

        leer.nextLine();

            String nombre = "";
                while (nombre.equals("")){
                    System.out.println("Ingrese el nombre del vendedor");

                    nombre = leer.next().toLowerCase();
                        if (!nombre.matches("^[A-Za-z ]*$")){
                            System.out.println("EL tipo de dato ingresado es incorrecto se esperaba caracteres");
                            nombre="";
                        }else{
                            v1.setNombre(nombre);
                        }
                }

        do {
            try {
                System.out.println("Ingrese el sueldo del vendedor");
                bandera = false;
                v1.setSueldo(leer.nextDouble());
            } catch (InputMismatchException e) {
                leer.next();
                bandera = true;
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
        } while (bandera);
        leer.nextLine();

        listaDeVendedor.add(v1);
        System.out.println("El Vendedor se ha creado exitosamente");
        System.out.println(v1);
    }

    public Vendedor buscarVendedorCodigo(int codigo, List<Vendedor> listaDeVendedor){
        return listaDeVendedor.stream().filter(vendedor -> vendedor.getCodigo()==codigo).findAny().orElse(null);
    }

    public void calcularComision(List<Vendedor> listaDeVendedor) throws InputMismatchException {
        try {
            System.out.println("Ingrese el codigo del vendedor");

            Vendedor v1 = buscarVendedorCodigo(leer.nextInt(), listaDeVendedor);
            System.out.println(v1.getComision());
        } catch (InputMismatchException e) {
            leer.next();

            System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
        }
   }

}
