package edu.usal.pantalla.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.Vuelo_Cliente_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVuelo_Cliente;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Vuelo_Cliente_Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Vuelo_Cliente_Controller control;
	private JButton btnVolver;
	private JTable table;
	

	public Vuelo_Cliente_Vista(Vuelo_Cliente_Controller controller,Vuelo vuelo) {
		this.control = controller;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
        setBounds(100, 100, 954, 565);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 6, 0, 0));
		
		btnVolver = new JButton("Volver");
		btnVolver.setHorizontalAlignment(SwingConstants.LEFT);
		btnVolver.addActionListener(new CapturaBtnVuelo_Cliente(this));
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblMostrandoClientesDel = new JLabel("Mostrando clientes del vuelo:");
		panel_4.add(lblMostrandoClientesDel);
		lblMostrandoClientesDel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel(vuelo.getId_vuelo());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);
		setVisible(true);
	}

	
	
	public Vuelo_Cliente_Controller getControl() {
		return control;
	}



	public void setControl(Vuelo_Cliente_Controller control) {
		this.control = control;
	}



	public JButton getBtnVolver() {
		return btnVolver;
	}



	public void setBtnVolver(JButton btnMenuPrincipal) {
		this.btnVolver = btnMenuPrincipal;
	}

	
	
	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	private void close(){
        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
	
}
