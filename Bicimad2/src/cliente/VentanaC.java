package cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaC extends JFrame {

	public  JPanel contentPane;
	public  JTextField tfP1;
	public  JTextField tfP2;
	public  JTextField tfP3;
	public  JTextField tfP4;
	public JButton btRefrescar;
	public JButton btCoger1;
	public JButton btCoger2;
	public JButton btCoger3;
	public JButton btCoger4;
	public JButton btDejar1;
	public JButton btDejar2;
	public JButton btDejar3;
	public JButton btDejar4;

	public VentanaC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 300);
		this.setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Punto 1: ");
		label.setBounds(10, 18, 60, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Punto 2: ");
		label_1.setBounds(10, 55, 60, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Punto 3: ");
		label_2.setBounds(10, 97, 60, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("Punto 4: ");
		label_3.setBounds(10, 140, 60, 14);
		contentPane.add(label_3);

		tfP1 = new JTextField();
		tfP1.setText("10");
		tfP1.setColumns(10);
		tfP1.setBounds(91, 11, 86, 20);
		contentPane.add(tfP1);
		tfP1.setEditable(false);
		tfP1.setBackground(Color.WHITE);

		tfP2 = new JTextField();
		tfP2.setText("10");
		tfP2.setColumns(10);
		tfP2.setBounds(91, 49, 86, 20);
		contentPane.add(tfP2);
		tfP2.setEditable(false);
		tfP2.setBackground(Color.WHITE);

		tfP3 = new JTextField();
		tfP3.setText("10");
		tfP3.setColumns(10);
		tfP3.setBounds(91, 91, 86, 20);
		contentPane.add(tfP3);
		tfP3.setEditable(false);
		tfP3.setBackground(Color.WHITE);

		tfP4 = new JTextField();
		tfP4.setText("10");
		tfP4.setColumns(10);
		tfP4.setBounds(91, 134, 86, 20);
		contentPane.add(tfP4);
		tfP4.setEditable(false);
		tfP4.setBackground(Color.WHITE);

		btRefrescar = new JButton("Refrescar");
		
		btRefrescar.setBounds(91, 180, 100, 23);
		contentPane.add(btRefrescar);

		btCoger1 = new JButton("Coger bici");
		btCoger1.setBounds(205, 10, 100, 23);
		contentPane.add(btCoger1);

		btCoger2 = new JButton("Coger bici");
		btCoger2.setBounds(205, 48, 100, 23);
		contentPane.add(btCoger2);

		btCoger3 = new JButton("Coger bici");
		btCoger3.setBounds(205, 90, 100, 23);
		contentPane.add(btCoger3);

		btCoger4 = new JButton("Coger bici");
		btCoger4.setBounds(205, 133, 100, 23);
		contentPane.add(btCoger4);

		btDejar1 = new JButton("Dejar bici");
		btDejar1.setBounds(339, 6, 100, 23);
		contentPane.add(btDejar1);
		btDejar1.setEnabled(false);

		btDejar2 = new JButton("Dejar bici");
		btDejar2.setBounds(339, 46, 100, 23);
		contentPane.add(btDejar2);
		btDejar2.setEnabled(false);

		btDejar3 = new JButton("Dejar bici");
		btDejar3.setBounds(339, 88, 100, 23);
		contentPane.add(btDejar3);
		btDejar3.setEnabled(false);

		btDejar4 = new JButton("Dejar bici");
		btDejar4.setBounds(339, 131, 100, 23);
		contentPane.add(btDejar4);
		btDejar4.setEnabled(false);
		
		
	}
}
