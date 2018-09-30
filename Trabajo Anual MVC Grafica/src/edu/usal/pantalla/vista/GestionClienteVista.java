package edu.usal.pantalla.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.pantalla.controller.GestionClienteController;
import edu.usal.pantalla.vista.eventos.CapturaBtnGestionCliente;
import edu.usal.pantalla.vista.frames.FrameModCliente;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class GestionClienteVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrameNuevoCliente nuevoCliente;
	private FrameModCliente modCliente;
	private JButton btnNuevo;
	private JButton btnMod;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnVolverAlMenu;
	private JLabel lblCartelSelec;
	private GestionClienteController clienteController;
	

	public FrameModCliente getModCliente() {
		return modCliente;
	}

	public void setModCliente(FrameModCliente modCliente) {
		this.modCliente = modCliente;
	}

	public GestionClienteVista(GestionClienteController menu) {
		this.clienteController = menu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenuCliente = new JPanel();
		panelMenuCliente.setBounds(5, 5, 969, 35);
		contentPane.add(panelMenuCliente);
		
		btnNuevo = new JButton("Nuevo Cliente");
		btnNuevo.addActionListener(new CapturaBtnGestionCliente(this));
		panelMenuCliente.add(btnNuevo);
		
		btnMod = new JButton("Modificar Cliente");
		btnMod.addActionListener(new CapturaBtnGestionCliente(this));
		panelMenuCliente.add(btnMod);
		
		btnEliminar = new JButton("Eliminar Cliente");
		btnEliminar.addActionListener(new CapturaBtnGestionCliente(this));
		panelMenuCliente.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar Cliente");
		btnBuscar.addActionListener(new CapturaBtnGestionCliente(this));
		panelMenuCliente.add(btnBuscar);
		
		btnVolverAlMenu = new JButton("Volver al menu principal");
		btnVolverAlMenu.setBounds(5, 650, 171, 25);
		btnVolverAlMenu.addActionListener(new CapturaBtnGestionCliente(this));
		contentPane.add(btnVolverAlMenu);
		
		lblCartelSelec = new JLabel("Seleccione una opcion");
		lblCartelSelec.setBounds(258, 51, 488, 173);
		contentPane.add(lblCartelSelec);
		lblCartelSelec.setFont(new Font("Arial", Font.PLAIN, 36));
		lblCartelSelec.setHorizontalAlignment(SwingConstants.CENTER);
		
		nuevoCliente = new FrameNuevoCliente(this);
		nuevoCliente.setBounds(5, 53, 969, 590);
		contentPane.add(nuevoCliente);
		
		modCliente = new FrameModCliente();
		modCliente.setBounds(5, 53, 969, 590);
		contentPane.add(modCliente);
		setVisible(true);
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnMod() {
		return btnMod;
	}

	public void setBtnMod(JButton btnMod) {
		this.btnMod = btnMod;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnVolverAlMenu() {
		return btnVolverAlMenu;
	}

	public void setBtnVolverAlMenu(JButton btnVolverAlMenu) {
		this.btnVolverAlMenu = btnVolverAlMenu;
	}
	
	public JLabel getLblCartelSelec() {
		return lblCartelSelec;
	}

	public void setLblCartelSelec(JLabel lblCartelSelec) {
		this.lblCartelSelec = lblCartelSelec;
	}
	public FrameNuevoCliente getNuevoCliente() {
		return nuevoCliente;
	}

	public void setNuevoCliente(FrameNuevoCliente nuevoCliente) {
		this.nuevoCliente = nuevoCliente;
	}

	public GestionClienteController getClienteController() {
		return clienteController;
	}

	public void setClienteController(GestionClienteController menu) {
		this.clienteController = menu;
	}
	public int solicitarDNI() {
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese DNI del cliente a modificar", "Modificar Cliente", JOptionPane.QUESTION_MESSAGE));
	}
	public int confirmarSeleccion(Cliente cliente) {
		return JOptionPane.showConfirmDialog(null, ("Desea seleccionar a Apellido: "+cliente.getApellido()+"\nNombre: "+cliente.getNombre()+"\nDNI: ["+cliente.getDNI()+"]"), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
	
}
