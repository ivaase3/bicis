package servidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JTextField tfPunto1;
	public JTextField tfPunto2;
	public JTextField tfPunto3;
	public JTextField tfPunto4;

	public Vista() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel lblPunto = new JLabel("Punto 1: ");
		lblPunto.setBounds(46, 36, 60, 14);
		contentPane.add(lblPunto);
		
		JLabel lblPunto_1 = new JLabel("Punto 2: ");
		lblPunto_1.setBounds(46, 74, 60, 14);
		contentPane.add(lblPunto_1);
		
		JLabel lblPunto_2 = new JLabel("Punto 3: ");
		lblPunto_2.setBounds(46, 116, 60, 14);
		contentPane.add(lblPunto_2);
		
		JLabel lblPunto_3 = new JLabel("Punto 4: ");
		lblPunto_3.setBounds(46, 159, 60, 14);
		contentPane.add(lblPunto_3);
		
		tfPunto1 = new JTextField();
		tfPunto1.setBounds(142, 30, 86, 20);
		contentPane.add(tfPunto1);
		tfPunto1.setColumns(10);
		tfPunto1.setEditable(false);
		tfPunto1.setBackground(Color.WHITE);
		
		tfPunto2 = new JTextField();
		tfPunto2.setColumns(10);
		tfPunto2.setBounds(142, 68, 86, 20);
		contentPane.add(tfPunto2);
		tfPunto2.setEditable(false);
		tfPunto2.setBackground(Color.WHITE);
		
		tfPunto3 = new JTextField();
		tfPunto3.setColumns(10);
		tfPunto3.setBounds(142, 110, 86, 20);
		contentPane.add(tfPunto3);
		tfPunto3.setEditable(false);
		tfPunto3.setBackground(Color.WHITE);
		
		
		
		tfPunto4 = new JTextField();
		tfPunto4.setColumns(10);
		tfPunto4.setBounds(142, 153, 86, 20);
		contentPane.add(tfPunto4);
		tfPunto4.setEditable(false);
		tfPunto4.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	
	
	
	
	
	
}
