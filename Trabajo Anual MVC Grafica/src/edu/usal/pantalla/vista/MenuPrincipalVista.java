package edu.usal.pantalla.vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.pantalla.controller.MenuPrincipalController;
import edu.usal.pantalla.vista.eventos.CapturaBtnMP;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipalVista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MenuPrincipalController mpController;
	
	private JPanel contentPane;
	private JLabel lblAerolinea;
	private JButton btnLineasAereas;
	private JButton btnVuelos;
	private JButton btnVenta;
	private JButton btnClientes;
	private JButton btnSalir;

	public MenuPrincipalController getMpController() {
		return mpController;
	}

	public void setMpController(MenuPrincipalController mpController) {
		this.mpController = mpController;
	}

	public MenuPrincipalVista(MenuPrincipalController mpController) {
		this.mpController = mpController;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAerolinea = new JLabel("Aeropuerto");
		lblAerolinea.setVerticalAlignment(SwingConstants.TOP);
		lblAerolinea.setFont(new Font("Verdana Pro SemiBold", Font.BOLD, 30));
		lblAerolinea.setBounds(229, 57, 211, 52);
		contentPane.add(lblAerolinea);
		
		btnLineasAereas = new JButton("Gestion Lineas Aereas");
		btnLineasAereas.setBounds(174, 261, 341, 75);
		contentPane.add(btnLineasAereas);
		
		btnVuelos = new JButton("Gestionar Vuelos");
		btnVuelos.setBounds(174, 369, 341, 75);
		contentPane.add(btnVuelos);
		
		btnVenta = new JButton("Venta");
		btnVenta.setBounds(174, 477, 341, 75);
		contentPane.add(btnVenta);
		
		btnClientes = new JButton("Gestion de Clientes");
		btnClientes.setBounds(174, 156, 341, 75);
		btnClientes.addActionListener(new CapturaBtnMP(this));
		contentPane.add(btnClientes);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(394, 585, 201, 52);
		contentPane.add(btnSalir);
		
		this.setVisible(true);
	}

	public JButton getBtnLineasAereas() {
		return btnLineasAereas;
	}

	public void setBtnLineasAereas(JButton btnLineasAereas) {
		this.btnLineasAereas = btnLineasAereas;
	}

	public JButton getBtnVuelos() {
		return btnVuelos;
	}

	public void setBtnVuelos(JButton btnVuelos) {
		this.btnVuelos = btnVuelos;
	}

	public JButton getBtnVenta() {
		return btnVenta;
	}

	public void setBtnVenta(JButton btnVenta) {
		this.btnVenta = btnVenta;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public void setBtnClientes(JButton btnClientes) {
		this.btnClientes = btnClientes;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	
	
}
