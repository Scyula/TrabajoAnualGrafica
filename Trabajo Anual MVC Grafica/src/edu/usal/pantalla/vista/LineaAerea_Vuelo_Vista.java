package edu.usal.pantalla.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.controller.LineaAerea_Vuelo_Controller;
import edu.usal.pantalla.controller.Vuelo_Cliente_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVuelo_Cliente;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class LineaAerea_Vuelo_Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LineaAerea_Vuelo_Controller control;
	private JButton btnVolver;
	private JButton btnVerPasajeros;
	private JTable table;
	

	public LineaAerea_Vuelo_Vista(LineaAerea_Vuelo_Controller controller, LineaAerea linea) {
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
		btnVolver.addActionListener(new CapturaBtnAeroLinea_Vuelo(this));
		panel.add(btnVolver);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		btnVerPasajeros = new JButton("Ver Pasajeros");
		btnVerPasajeros.addActionListener(new CapturaBtnAeroLinea_Vuelo(this));
		panel.add(btnVerPasajeros);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {} ));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel label = new JLabel("Mostrando vuelos de la Aerolinea:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(label);
		
		JLabel lblNombreAero = new JLabel(linea.getNombre());
		lblNombreAero.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNombreAero);
		
		setVisible(true);
	}

	
	
	public LineaAerea_Vuelo_Controller getControl() {
		return control;
	}



	public void setControl(LineaAerea_Vuelo_Controller control) {
		this.control = control;
	}



	public JButton getBtnVolver() {
		return btnVolver;
	}

	

	public JTable getTable() {
		return table;
	}



	public void setTable(JTable table) {
		this.table = table;
	}



	public void setBtnVolver(JButton btnMenuPrincipal) {
		this.btnVolver = btnMenuPrincipal;
	}
	
	

	public JButton getBtnVerPasajeros() {
		return btnVerPasajeros;
	}



	public void setBtnVerPasajeros(JButton btnVerPasajeros) {
		this.btnVerPasajeros = btnVerPasajeros;
	}



	public void cancelaOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha cancelado", "", JOptionPane.WARNING_MESSAGE);
	}
	public void exitoOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha completado con exito", "", JOptionPane.INFORMATION_MESSAGE);
	}
	public void fracasoOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion no se pudo realizar", "", JOptionPane.WARNING_MESSAGE);
	}
	private void close(){
        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    } 
	
	public int confirmarSeleccion(Cliente cliente,String causa) {
		return JOptionPane.showConfirmDialog(null, ("Desea seleccionar para su "+causa+" a\n Apellido: "+cliente.getApellido()+"\nNombre: "+cliente.getNombre()+"\nDNI: ["+cliente.getDNI()+"]"), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

}
