package edu.usal.pantalla.vista.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.vista.GestionLineaVista;
import edu.usal.pantalla.vista.eventos.CapturaBtnModLinea;
import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class FrameModLinea extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblLinea;
	private GestionLineaVista vista;
	private JComboBox comboBoxLinea;
	private JButton btnAceptar;
	private List<LineaAerea> lineas;


	public FrameModLinea(GestionLineaVista vista) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLinea = new JLabel("Seleccione Linea Aerea a Modificar");
		lblLinea.setFont(new Font("Dialog", Font.BOLD, 12));
		lblLinea.setBounds(104, 57, 200, 16);
		getContentPane().add(lblLinea);
		
		JComboBox comboBoxLinea = new JComboBox();
		comboBoxLinea.addActionListener(new CapturaBtnModLinea(this));
		comboBoxLinea.setBounds(96, 85, 219, 39);
		contentPane.add(comboBoxLinea);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new CapturaBtnModLinea(this));
		btnAceptar.setFont(new Font("Dialog", Font.BOLD, 12));
		btnAceptar.setBounds(122, 152, 171, 41);
		contentPane.add(btnAceptar);
	}


	public GestionLineaVista getVista() {
		return vista;
	}


	public void setVista(GestionLineaVista vista) {
		this.vista = vista;
	}


	public JComboBox getComboBoxLinea() {
		return comboBoxLinea;
	}


	public void setComboBoxLinea(JComboBox comboBoxLinea) {
		this.comboBoxLinea = comboBoxLinea;
	}


	public JButton getBtnAceptar() {
		return btnAceptar;
	}


	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	
}
