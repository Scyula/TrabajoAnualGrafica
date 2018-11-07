package edu.usal.pantalla.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.Vuelo_All_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVuelo_All;

public class Vuelo_All_Vista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Vuelo_All_Controller control;
	private DefaultListModel<Vuelo> modelo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnMenuPrincipal;
	private JList<Vuelo> list;
	private JButton btnMostrarClientes;
	

	public Vuelo_All_Vista(Vuelo_All_Controller controller) {
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
		
		JLabel lblSeleccioneUnVuelo = new JLabel("Seleccione un vuelo para la operacion");
		lblSeleccioneUnVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblSeleccioneUnVuelo, BorderLayout.NORTH);
		modelo = control.pedirListaVuelos();
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnMenuPrincipal = new JButton("Volver al Menu Principal");
		panel_5.add(btnMenuPrincipal);
		btnMenuPrincipal.setHorizontalAlignment(SwingConstants.LEFT);
		btnMenuPrincipal.addActionListener(new CapturaBtnVuelo_All(this));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8);
		
		btnMostrarClientes = new JButton("Mostrar clientes del vuelo");
		btnMostrarClientes.addActionListener(new CapturaBtnVuelo_All(this));
		panel_8.add(btnMostrarClientes);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		btnModificar = new JButton("Modificar");
		panel_3.add(btnModificar);
		btnModificar.addActionListener(new CapturaBtnVuelo_All(this));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		btnEliminar = new JButton("Eliminar");
		panel_4.add(btnEliminar);
		btnEliminar.addActionListener(new CapturaBtnVuelo_All(this));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList<Vuelo>();
		scrollPane.setViewportView(list);
		modelo= control.pedirListaVuelos();
		list.setModel(modelo);
		setVisible(true);
	}

	public Vuelo_All_Controller getControl() {
		return control;
	}

	public void setControl(Vuelo_All_Controller control) {
		this.control = control;
	}

	public JList<Vuelo> getList() {
		return list;
	}

	public void setList(JList<Vuelo> list) {
		this.list = list;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnMenuPrincipal() {
		return btnMenuPrincipal;
	}

	public void setBtnMenuPrincipal(JButton btnMenuPrincipal) {
		this.btnMenuPrincipal = btnMenuPrincipal;
	}

	public DefaultListModel<Vuelo> getModelo() {
		return modelo;
	}

	
	public JButton getBtnMostrarClientes() {
		return btnMostrarClientes;
	}

	public void setBtnMostrarClientes(JButton btnMostrarClientes) {
		this.btnMostrarClientes = btnMostrarClientes;
	}

	public void setModelo(DefaultListModel<Vuelo> modelo) {
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
	
	public int confirmarSeleccion(Vuelo vuelo,String causa) {
		return JOptionPane.showConfirmDialog(null, ("Desea seleccionar para su "+causa+" a\n ID: "+vuelo.getId_vuelo()), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	}

}
