package cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import bicimad.Punto;

public class Cliente implements ActionListener {
	public static boolean bici = false;
	static VentanaC ventana = new VentanaC();
	static String accion = "";
	static Object objetoEntrada = null;
//	static ArrayList<Punto> puntos;
	static ObjectOutputStream perSal;
	static ObjectInputStream perEnt;

	public Cliente(VentanaC ventana) {
		try {
			this.ventana = ventana;

			String host = "localhost";
			int puerto = 5555;
			Socket SCliente = new Socket(host, puerto);

			perSal = new ObjectOutputStream(SCliente.getOutputStream());

 			perEnt = new ObjectInputStream(SCliente.getInputStream());

 			objetoEntrada = (ArrayList<Punto>) perEnt.readObject();
//			objetoEntrada = puntos.clone();
//			System.out.println(puntos.get(0).getnDisponibles());  

			ventana.btRefrescar.setActionCommand("refrescar");
			ventana.btRefrescar.addActionListener(this);
			ventana.btCoger1.setActionCommand("coger1");
			ventana.btCoger1.addActionListener(this);
			ventana.btCoger2.setActionCommand("coger2");
			ventana.btCoger2.addActionListener(this);
			ventana.btCoger3.setActionCommand("coger3");
			ventana.btCoger3.addActionListener(this);
			ventana.btCoger4.setActionCommand("coger4");
			ventana.btCoger4.addActionListener(this);
			ventana.btDejar1.setActionCommand("dejar1");
			ventana.btDejar1.addActionListener(this);
			ventana.btDejar2.setActionCommand("dejar2");
			ventana.btDejar2.addActionListener(this);
			ventana.btDejar3.setActionCommand("dejar3");
			ventana.btDejar3.addActionListener(this);
			ventana.btDejar4.setActionCommand("dejar4");
			ventana.btDejar4.addActionListener(this);

//			while (true) {
//				perSal.writeObject(accion);
//				objetoEntrada = perEnt.readObject();
//
//			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new Cliente(ventana);

	}

	public static void refrescar(ArrayList<Punto> puntos, VentanaC ventana, boolean bici) {

		ventana.tfP1.setText(String.valueOf(puntos.get(0).getnDisponibles()));
		ventana.tfP2.setText(String.valueOf(puntos.get(1).getnDisponibles()));
		ventana.tfP3.setText(String.valueOf(puntos.get(2).getnDisponibles()));
		ventana.tfP4.setText(String.valueOf(puntos.get(3).getnDisponibles()));

		if (bici) {
			ventana.btCoger1.setEnabled(false);
			ventana.btCoger2.setEnabled(false);
			ventana.btCoger3.setEnabled(false);
			ventana.btCoger4.setEnabled(false);
			if (puntos.get(0).getnDisponibles() < 10) {
				ventana.btDejar1.setEnabled(true);
			}
			if (puntos.get(1).getnDisponibles() < 10) {
				ventana.btDejar2.setEnabled(true);
			}
			if (puntos.get(2).getnDisponibles() < 10) {
				ventana.btDejar3.setEnabled(true);
			}
			if (puntos.get(3).getnDisponibles() < 10) {
				ventana.btDejar4.setEnabled(true);
			}

		} else {
			ventana.btDejar1.setEnabled(false);
			ventana.btDejar2.setEnabled(false);
			ventana.btDejar3.setEnabled(false);
			ventana.btDejar4.setEnabled(false);
			if (puntos.get(0).getnDisponibles() > 0) {
				ventana.btDejar1.setEnabled(true);
			}
			if (puntos.get(1).getnDisponibles() > 0) {
				ventana.btDejar2.setEnabled(true);
			}
			if (puntos.get(2).getnDisponibles() > 0) {
				ventana.btDejar3.setEnabled(true);
			}
			if (puntos.get(3).getnDisponibles() > 0) {
				ventana.btDejar4.setEnabled(true);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Object objetoEntrada2 = null;
		try {
			switch (e.getActionCommand()) {
			case "refrescar":
				accion = "refrescar";
				perSal.writeObject(accion);
				
				objetoEntrada = (perEnt.readObject());
				refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
				
				break;
			case "coger1":

				accion = "coger1";
				perSal.writeObject(accion);
				
				objetoEntrada =(ArrayList<Punto>) perEnt.readObject();
				System.out.println(objetoEntrada);
				if (!(objetoEntrada instanceof String)) {
					
					//TODO le resto uno porque no se por que le mal el objeto 
//					((ArrayList<Punto>) objetoEntrada).get(0).setnDisponibles(((ArrayList<Punto>) objetoEntrada).get(0).getnDisponibles() - 1);	
					
					System.out.println(((ArrayList<Punto>) objetoEntrada).get(0).getnDisponibles()); 
//					System.out.println(((ArrayList<Punto>) puntos).get(0).getnDisponibles()); 
					
					bici = true;
					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);

				} else {
					String mensaje = (String) objetoEntrada;
					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
				}

				break;
			case "coger2":

				accion="coger2";	
				perSal.writeObject(accion);		
				
				objetoEntrada = (perEnt.readObject());
				if (!(objetoEntrada instanceof String)) {
					//TODO le resto uno porque no se por que le mal el objeto 
					((ArrayList<Punto>) objetoEntrada).get(1).setnDisponibles(((ArrayList<Punto>) objetoEntrada).get(1).getnDisponibles() - 1);					
					bici = true;
					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);

				} else {
					String mensaje = (String) objetoEntrada;
					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
//			case "coger3":
//
//				perSal.writeObject("coger3");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;
//			case "coger4":
//
//				perSal.writeObject("coger4");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;

//			case "dejar1":
//
//				perSal.writeObject("dejar1");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;
//			case "dejar2":
//
//				perSal.writeObject("dejar2");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;
//			case "dejar3":
//
//				perSal.writeObject("dejar3");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;
//			case "dejar4":
//
//				perSal.writeObject("dejar4");
//				objetoEntrada = perEnt.readObject();
//				if (!(objetoEntrada instanceof String)) {
//					bici = true;
//					refrescar((ArrayList<Punto>) objetoEntrada, ventana, bici);
//
//				} else {
//					String mensaje = (String) objetoEntrada;
//					JOptionPane.showMessageDialog(null, "mensaje", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//
//				break;
			default:

				break;

			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
