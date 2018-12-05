package edu.usal.pantalla.vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Cliente;
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

public class Vuelo_Cliente_Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Vuelo_Cliente_Controller control;
	private DefaultListModel<Cliente> modelo;
	private JButton btnVolver;
	private JList<Cliente> listaClientes;
	

	public Vuelo_Cliente_Vista(Vuelo_Cliente_Controller controller) {
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
		
		JLabel lblSeleccioneUnaCliente = new JLabel("Seleccione una cliente para la operacion");
		lblSeleccioneUnaCliente.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSeleccioneUnaCliente, BorderLayout.NORTH);
		modelo = control.pedirListaClientes();
		
		
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
		
		listaClientes = new JList<Cliente>();
		scrollPane.setViewportView(listaClientes);
		modelo= control.pedirListaClientes();
		listaClientes.setModel(modelo);
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



	public JList<Cliente> getList() {
		return listaClientes;
	}



	public void setList(JList<Cliente> list) {
		this.listaClientes = list;
	}



	public DefaultListModel<Cliente> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<Cliente> modelo) {
		this.modelo = modelo;
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
