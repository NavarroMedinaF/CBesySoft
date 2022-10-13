package com.ChallengeBesysoft.CBesysoft.Service;

import java.util.Scanner;

public class ServicePanelControl {

    Scanner leer = new Scanner(System.in);

    public boolean deseaContinuar( boolean bandera){
        System.out.println("¿Desea continuar en el panel de control? \n Si \n No");
        String respuesta = leer.nextLine();

        bandera= !respuesta.equalsIgnoreCase("si");
        return bandera;
    }

    public int inicioPanerControl(){
        int indice;
        System.out.println("Bienvenidos al panel de control \n Por favor elija una de las siguientes opciones. " +
                "\n 1:Alta Vendedor. \n 2:Alta producto. \n 3:Realizar venta. \n 4:Buscar productos por categoria. " +
                "\n 5:Buscar productos por codigo. \n 6:Buscar ventas. \n 7:Calcular comiciones. " +
                "\n 8:Filtrar Productos por MAYOR valor. \n 9:Filtrar Productos por MENOR valor ");
        indice = leer.nextInt();
        leer.nextLine();
        return indice;
    }
}
