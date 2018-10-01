package edu.usal.pantalla.vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.GestionClienteController;
import edu.usal.pantalla.controller.GestionVueloController;
import edu.usal.pantalla.vista.eventos.CapturaBtnGestionVuelo;
import edu.usal.pantalla.vista.frames.FrameModCliente;
import edu.usal.pantalla.vista.frames.FrameModVuelo;
import edu.usal.pantalla.vista.frames.FrameNuevaLinea;
import edu.usal.pantalla.vista.frames.FrameNuevoCliente;
import edu.usal.pantalla.vista.frames.FrameNuevoVuelo;

public class GestionVueloVista extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FrameNuevoVuelo nuevoVuelo;
	private FrameModVuelo modVuelo;
	private JButton btnNuevo;
	private JButton btnMod;
	private JButton btnEliminar;
	private JButton btnBuscar;
	private JButton btnVolverAlMenu;
	private JLabel lblCartelSelec;
	private GestionVueloController vueloController;
	
	

	public FrameModVuelo getModLinea() {
		return modVuelo;
	}

	public void setModLinea(FrameModVuelo modLinea) {
		this.modVuelo = modLinea;
	}

	public GestionVueloVista(GestionVueloController menu) {
		this.vueloController = menu;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenuLinea = new JPanel();
		panelMenuLinea.setBounds(5, 5, 969, 35);
		contentPane.add(panelMenuLinea);
		
		btnNuevo = new JButton("Nuevo Vuelo");
		btnNuevo.addActionListener(new CapturaBtnGestionVuelo(this));
		panelMenuLinea.add(btnNuevo);
		
		btnMod = new JButton("Modificar Vuelo");
		btnMod.addActionListener(new CapturaBtnGestionVuelo(this));
		panelMenuLinea.add(btnMod);
		
		btnEliminar = new JButton("Eliminar Vuelo");
		btnEliminar.addActionListener(new CapturaBtnGestionVuelo(this));
		panelMenuLinea.add(btnEliminar);
		
		btnBuscar = new JButton("Buscar Vuelo");
		btnBuscar.addActionListener(new CapturaBtnGestionVuelo(this));
		panelMenuLinea.add(btnBuscar);
		
		btnVolverAlMenu = new JButton("Volver al menu principal");
		btnVolverAlMenu.setBounds(5, 650, 171, 25);
		btnVolverAlMenu.addActionListener(new CapturaBtnGestionVuelo(this));
		contentPane.add(btnVolverAlMenu);
		
		lblCartelSelec = new JLabel("Seleccione una opcion");
		lblCartelSelec.setBounds(258, 51, 488, 173);
		contentPane.add(lblCartelSelec);
		lblCartelSelec.setFont(new Font("Arial", Font.PLAIN, 36));
		lblCartelSelec.setHorizontalAlignment(SwingConstants.CENTER);
		
		nuevoVuelo = new FrameNuevoVuelo(this);
		nuevoVuelo.setBounds(5, 53, 969, 590);
		contentPane.add(nuevoVuelo);
		
		modVuelo = new FrameModVuelo();
		modVuelo.setBounds(5, 53, 969, 590);
		contentPane.add(modVuelo);
		setVisible(true);
	}

	
	public FrameNuevoVuelo getNuevoVuelo() {
		return nuevoVuelo;
	}

	public void setNuevoVuelo(FrameNuevoVuelo nuevoVuelo) {
		this.nuevoVuelo = nuevoVuelo;
	}

	public FrameModVuelo getModVuelo() {
		return modVuelo;
	}

	public void setModVuelo(FrameModVuelo modVuelo) {
		this.modVuelo = modVuelo;
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

	public GestionVueloController getVueloController() {
		return vueloController;
	}

	public void setVueloController(GestionVueloController vueloController) {
		this.vueloController = vueloController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public JLabel getLblCartelSelec() {
		return lblCartelSelec;
	}

	public void setLblCartelSelec(JLabel lblCartelSelec) {
		this.lblCartelSelec = lblCartelSelec;
	}

	public int solicitarID() {
		return Integer.parseInt((JOptionPane.showInputDialog(null, "Ingrese ID del Vuelo a modificar", "Modificar Vuelo", JOptionPane.QUESTION_MESSAGE)));
	}
	public int confirmarSeleccion(Vuelo vuelo) {
		return JOptionPane.showConfirmDialog(null, ("Desea eliminar a "+vuelo.getId_vuelo()+" "+vuelo.getNombreAerolinea()+"["+vuelo.getAeropuertoSalida()+" - "+vuelo.getAeropuertoLlegada()+"]"), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
