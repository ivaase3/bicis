package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import bicimad.Bicicleta;
import bicimad.Punto;

public class Servidor {

	// Atributos
	
//	public static ArrayList<Punto> puntos = new ArrayList<>();

	public static void main(String[] args) {
		try {
			// creacion de bicis y puntos
			final int TOTALES = 10;
			int id = 0;
			Hilo hilo;
			ArrayList<Punto> puntos = new ArrayList<>();
			
			
			
			System.out.println("creando los datos");
			for (int i = 0; i < 5; i++) {
				Punto punto = new Punto("calle " + i, TOTALES);
				for (int j = 0; j < TOTALES; j++) {
					Bicicleta bicicleta = new Bicicleta(id);
					punto.getPunto().add(bicicleta);
					punto.setnDisponibles(punto.getnDisponibles() + 1);
					id++;
				}
				puntos.add(punto);
			}

			// Inicializacion
			System.out.println("Esperando mensajes");
			Vista vista = new Vista();
			iniciaDatosVentana(vista,puntos);
			
			ServerSocket servidor = new ServerSocket(5555);
			System.out.println("Conexion iniciada");
			int cont = 0;
			while (true) {
				Socket clienteConectado = servidor.accept();
				cont++;
				System.out.println("cliente onectado" + cont);
				hilo = new Hilo(clienteConectado,cont, puntos,vista);
				hilo.start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void iniciaDatosVentana(Vista vista, ArrayList<Punto> puntos) {
		vista.tfPunto1.setText(String.valueOf(puntos.get(0).getTotal()));
		vista.tfPunto2.setText(String.valueOf(puntos.get(1).getTotal()));
		vista.tfPunto3.setText(String.valueOf(puntos.get(2).getTotal()));
		vista.tfPunto4.setText(String.valueOf(puntos.get(3).getTotal()));
	}
}



