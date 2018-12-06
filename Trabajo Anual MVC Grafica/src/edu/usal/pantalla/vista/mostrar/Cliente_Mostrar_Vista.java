package edu.usal.pantalla.vista.mostrar;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.usal.pantalla.controller.mostrar.Cliente_Mostrar_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnClientes_Mostrar;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Cliente_Mostrar_Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4490598893203214936L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnSeleccionar;
	private JButton btnVolver;
	private Cliente_Mostrar_Controller controller;
	

	public Cliente_Mostrar_Vista(Cliente_Mostrar_Controller cliente_Buscar_Controller) {
		this.controller = cliente_Buscar_Controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblBuscarCliente = new JLabel("Mostrando  clientes");
		lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBuscarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblBuscarCliente);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {} ));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(1, 7, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.SOUTH);
		
		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10, BorderLayout.WEST);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11, BorderLayout.EAST);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new CapturaBtnClientes_Mostrar(this));
		panel_3.add(btnVolver, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_7.add(panel_14, BorderLayout.NORTH);
		
		JPanel panel_15 = new JPanel();
		panel_7.add(panel_15, BorderLayout.SOUTH);
		
		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17, BorderLayout.EAST);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new CapturaBtnClientes_Mostrar(this));
		panel_7.add(btnSeleccionar, BorderLayout.CENTER);
		
		this.setVisible(true);
	}


	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}


	public JButton getBtnSeleccionar() {
		return btnSeleccionar;
	}


	public void setBtnSeleccionar(JButton btnSeleccionar) {
		this.btnSeleccionar = btnSeleccionar;
	}


	public JButton getBtnVolver() {
		return btnVolver;
	}


	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}


	public Cliente_Mostrar_Controller getController() {
		return controller;
	}


	public void setController(Cliente_Mostrar_Controller controller) {
		this.controller = controller;
	}

	
	
}
