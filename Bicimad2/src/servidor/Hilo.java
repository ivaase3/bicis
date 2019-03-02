package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import bicimad.Punto;

public class Hilo extends Thread {
	Socket cliente;
	int cont;
	ArrayList<Punto> puntos;
	Vista vista;

	Hilo(Socket cliente, int cont, ArrayList<Punto> puntos, Vista vista) {
		this.cliente = cliente;
		this.cont = cont;
		this.puntos = puntos;
		this.vista = vista;
	}

	public void run() {
		try {
			ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());

			outObjeto.writeObject(puntos);
			String cadena = (String) inObjeto.readObject();

			switch (cadena) {
			case "refrescar":
				rfrscar(vista,puntos);
				
				outObjeto.writeObject(puntos);
				break;
			case "coger1":
				if (puntos.get(0).getnDisponibles() > 0) {
					puntos.get(0).setnDisponibles(puntos.get(0).getnDisponibles() - 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "coger2":
				if (puntos.get(1).getnDisponibles() > 0) {
					puntos.get(1).setnDisponibles(puntos.get(1).getnDisponibles() - 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "coger3":
				if (puntos.get(2).getnDisponibles() > 0) {
					puntos.get(2).setnDisponibles(puntos.get(2).getnDisponibles() - 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "coger4":
				if (puntos.get(3).getnDisponibles() > 0) {
					puntos.get(3).setnDisponibles(puntos.get(3).getnDisponibles() - 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "dejar1":
				if (puntos.get(0).getnDisponibles() < 10) {
					puntos.get(0).setnDisponibles(puntos.get(0).getnDisponibles() + 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "dejar2":
				if (puntos.get(1).getnDisponibles() < 10) {
					puntos.get(1).setnDisponibles(puntos.get(1).getnDisponibles() + 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "dejar3":
				if (puntos.get(2).getnDisponibles() < 10) {
					puntos.get(2).setnDisponibles(puntos.get(2).getnDisponibles() + 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			case "dejar4":
				if (puntos.get(3).getnDisponibles() < 10) {
					puntos.get(3).setnDisponibles(puntos.get(3).getnDisponibles() + 1);
					rfrscar(vista,puntos);
					outObjeto.writeObject(puntos);
				} else {
					outObjeto.writeObject("error");
				}
				break;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void rfrscar(Vista vista, ArrayList<Punto> puntos){
		vista.tfPunto1.setText(String.valueOf(puntos.get(0).getnDisponibles()));
		vista.tfPunto2.setText(String.valueOf(puntos.get(1).getnDisponibles()));
		vista.tfPunto3.setText(String.valueOf(puntos.get(2).getnDisponibles()));
		vista.tfPunto4.setText(String.valueOf(puntos.get(3).getnDisponibles()));
	}

}
