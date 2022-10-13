package com.ChallengeBesysoft.CBesysoft.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ServicePanelControl {

    Scanner leer = new Scanner(System.in);

    public boolean deseaContinuar( boolean bandera){
        String resp = "";
        while (resp.equals("")){
            System.out.println("¿Desea continuar en el panel de control? \n Si \n No");

            resp = leer.next().toLowerCase();
            if (!resp.matches("^[A-Za-z ]*$")){
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba caracteres");
                resp="";
            }else{
                bandera= !resp.equalsIgnoreCase("si");

            }
        }
        return bandera;
    }

    public int inicioPanerControl() throws InputMismatchException {
        int indice = 0;
            try {
                System.out.println("Bienvenidos al panel de control \n Por favor elija una de las siguientes opciones. " +
                        "\n 1:Alta Vendedor. \n 2:Alta producto. \n 3:Realizar venta. \n 4:Buscar productos por categoria. " +
                        "\n 5:Buscar productos por codigo. \n 6:Buscar ventas. \n 7:Calcular comiciones. " +
                        "\n 8:Filtrar Productos por MAYOR valor. \n 9:Filtrar Productos por MENOR valor ");
                indice = leer.nextInt();
                leer.nextLine();

            } catch (InputMismatchException e) {
                leer.next();
                System.out.println("EL tipo de dato ingresado es incorrecto se esperaba un numero");
            }
            return indice;


    }
}
