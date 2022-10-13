package com.ChallengeBesysoft.CBesysoft;

import com.ChallengeBesysoft.CBesysoft.Service.ServicePanelControl;
import com.ChallengeBesysoft.CBesysoft.Service.ServiceVenta;
import com.ChallengeBesysoft.CBesysoft.Service.ServiceProducto;
import com.ChallengeBesysoft.CBesysoft.Service.ServiceVendedor;
import com.ChallengeBesysoft.CBesysoft.models.Productos;
import com.ChallengeBesysoft.CBesysoft.models.Vendedor;
import com.ChallengeBesysoft.CBesysoft.models.Ventas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@SpringBootApplication
public class CBesysoftApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CBesysoftApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*SCANNER*/
		Scanner leer = new Scanner(System.in);


		/*SERVICIOS*/
		ServiceVendedor sv = new ServiceVendedor();
		ServiceProducto sp = new ServiceProducto();
		ServiceVenta sventa= new ServiceVenta();
		ServicePanelControl spc= new ServicePanelControl();


		/*VARIABLES*/
		int indice=0;
		boolean bandera = false;
		List<Vendedor> listaDeVendedor = new ArrayList<>();
		List<Productos> listaDeProductos = new ArrayList<>();
		List<Ventas> listaDeVentas= new ArrayList<>();

		Vendedor vendedor1 = new Vendedor(1,"Facundo Navarro", 100000);
		listaDeVendedor.add(vendedor1);

		Productos producto1= new Productos(1,"Chevrollet S10 3.8l", 1500000, "camioneta");
		listaDeProductos.add(producto1);
		Productos producto2= new Productos(1,"Scannia 100 5l", 15000000, "camion");
		listaDeProductos.add(producto2);
		Productos producto3= new Productos(1,"Fiat uno 1.5l", 150000, "automotor");
		listaDeProductos.add(producto3);
		Productos producto4= new Productos(1,"Yamaha Slash 1l", 190000, "motocicleta");
		listaDeProductos.add(producto4);


		Ventas venta1 = new Ventas(1,producto1,vendedor1);
		listaDeVentas.add(venta1);

		/*APP*/
		do{
			indice =spc.inicioPanerControl();

		switch (indice){
			case 1:
				sv.altaVendedor(listaDeVendedor);
				bandera=spc.deseaContinuar(false);

				break;

			case 2:
				sp.altaProducto( listaDeProductos);
				bandera=spc.deseaContinuar(false);
			break;

			case 3:
				sventa.crearVentas(listaDeVendedor,listaDeProductos,  listaDeVentas);
				bandera=spc.deseaContinuar(false);
				break;

			case 4:
				System.out.println("Ingrese la categoria del producto");
				System.out.println(sp.buscarProductoCategoria(leer.next(), listaDeProductos ));
				bandera=spc.deseaContinuar(false);
				break;

			case 5:
				System.out.println("Ingrese el codigo del producto");
				System.out.println(sp.buscarProductoCodigo(leer.nextInt(),listaDeProductos ));
				bandera=spc.deseaContinuar(false);
				break;

			case 6:
				System.out.println(sventa.buscarVenta(listaDeVentas));
				bandera=spc.deseaContinuar(false);
				break;

			case 7:
				sv.calcularComision( listaDeVendedor);
				bandera=spc.deseaContinuar(false);
				break;

		}
		}while(!bandera);
	}


}
