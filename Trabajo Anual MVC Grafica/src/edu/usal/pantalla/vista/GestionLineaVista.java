package edu.usal.pantalla.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.controller.GestionClienteController;
import edu.usal.pantalla.controller.GestionLineaController;
import edu.usal.pantalla.vista.eventos.CapturaBtnGestionCliente;
import edu.usal.pantalla.vista.eventos.CapturaBtnGestionLinea;
import edu.usal.pantalla.vista.frames.FrameModCliente;
import edu.usal.pantalla.vista.frames.FrameModLinea;
import edu.usal.pantalla.vista.frames.FrameNuevaLinea;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;

public class GestionLineaVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrameNuevaLinea nuevaLinea;
	private FrameModLinea modLinea;
	private JButton btnNuevo;
	private JButton btnMod;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnVolverAlMenu;
	private JLabel lblCartelSelec;
	private GestionLineaController lineaController;
	
	

	public FrameModLinea getModLinea() {
		return modLinea;
	}

	public void setModLinea(FrameModLinea modLinea) {
		this.modLinea = modLinea;
	}

	public GestionLineaVista(GestionLineaController menu) {
		this.lineaController = menu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenuLinea = new JPanel();
		panelMenuLinea.setBounds(5, 5, 969, 35);
		contentPane.add(panelMenuLinea);
		
		btnNuevo = new JButton("Nueva Linea Aerea");
		btnNuevo.addActionListener(new CapturaBtnGestionLinea(this));
		panelMenuLinea.add(btnNuevo);
		
		btnMod = new JButton("Modificar Linea Aerea");
		btnMod.addActionListener(new CapturaBtnGestionLinea(this));
		panelMenuLinea.add(btnMod);
		
		btnEliminar = new JButton("Eliminar Linea Aerea");
		btnEliminar.addActionListener(new CapturaBtnGestionLinea(this));
		panelMenuLinea.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar Linea Aerea");
		btnBuscar.addActionListener(new CapturaBtnGestionLinea(this));
		panelMenuLinea.add(btnBuscar);
		
		btnVolverAlMenu = new JButton("Volver al menu principal");
		btnVolverAlMenu.setBounds(5, 650, 171, 25);
		btnVolverAlMenu.addActionListener(new CapturaBtnGestionLinea(this));
		contentPane.add(btnVolverAlMenu);
		
		lblCartelSelec = new JLabel("Seleccione una opcion");
		lblCartelSelec.setBounds(258, 51, 488, 173);
		contentPane.add(lblCartelSelec);
		lblCartelSelec.setFont(new Font("Arial", Font.PLAIN, 36));
		lblCartelSelec.setHorizontalAlignment(SwingConstants.CENTER);
		
		nuevaLinea = new FrameNuevaLinea(this);
		nuevaLinea.setBounds(5, 53, 969, 590);
		contentPane.add(nuevaLinea);
		
		modLinea = new FrameModLinea(this);
		modLinea.setBounds(5, 53, 969, 590);
		contentPane.add(modLinea);
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
	public FrameNuevaLinea getNuevaLinea() {
		return nuevaLinea;
	}

	public void setNuevaLinea(FrameNuevaLinea nuevaLinea) {
		this.nuevaLinea = nuevaLinea;
	}

	public GestionLineaController getLineaController() {
		return lineaController;
	}

	public void setLineaController(GestionLineaController menu) {
		this.lineaController = menu;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public JComboBox solicitarLinea() {
		return (this.getModLinea().getComboBoxLinea());
		
		
	}
	
	public int confirmarSeleccion(LineaAerea linea) {
		
		return JOptionPane.showConfirmDialog(null, ("Desea eliminar a "+linea.getNombre()+"["+linea.getAlianza()+"]"), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
