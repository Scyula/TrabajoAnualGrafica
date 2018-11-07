package edu.usal.pantalla.vista;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import edu.usal.negocio.dominio.Vuelo;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.pantalla.controller.Vuelo_Datos_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVuelo_Datos;

public class Vuelo_Datos_Vista extends JFrame {
	public Vuelo_Datos_Vista() {
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Vuelo_Datos_Controller vista;
	
	private JPanel contentPane;

	private JLabel lblCantAsientos;
	private JLabel lblTiempoVuelo;
	private JLabel lblFechaSalida;
	private JTextField textCantAsientos;
	private JTextField textTiempoVuelo;
	private JButton btnGuardar;
	private JButton btnGuardarMod;
	private JButton btnCancelar;
	private JLabel lblPaisLlegada;
	private JLabel lblProvinciaLlegada;
	private JLabel lblFechaLlegada;
	private JLabel lblDatosBasicos;
	private JLabel lblSalida;
	private JLabel lblLlegada;
	private JComboBox<Pais> comboBox_PaisLlegada;
	private JComboBox<Provincia> comboBox_ProvinciaLlegada;
	private JComboBox<LineaAerea> comboBox_Aerolinea;
	private JTextField textAlianza;
	private JDateChooser FechaLlegada;
	private JDateChooser FechaSalida;
	private JComboBox<Pais> comboBox_PaisSalida;
	private JComboBox<Provincia>comboBox_ProvinciaSalida;
	private JLabel lblPaisSalida;
	private JLabel lblProvinciaSalida;
	private JTextField textHoraSalida;
	private JLabel lblHoraSalida;
	private JTextField textHoraLlegada;
	private JLabel lblHoraLlegada;
	private JTextField textCiudadSalida;
	private JLabel lblCiudadSalida;
	private JTextField textCiudadLlegada;
	private JLabel lblCiudadLlegada;
	
	public Vuelo_Datos_Vista(Vuelo_Datos_Controller vista) {
		
		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		setBounds(5, 53, 980, 694);
		setLocationRelativeTo(null);
		
		
		setTitle("Alta de Vuelo");
		getContentPane().setLayout(null);
		

		DefaultComboBoxModel<Pais> modelo2 = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());
		DefaultComboBoxModel<Pais> modelo = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());

		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnVuelo_Datos(this));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnVuelo_Datos(this));
		btnCancelar.setBounds(822, 602, 97, 25);
		getContentPane().add(btnCancelar);
		btnGuardar.setBounds(698, 601, 97, 25);
		getContentPane().add(btnGuardar);
		

		JPanel panel = new JPanel();
		panel.setBounds(31, 78, 382, 217);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(446, 78, 473, 217);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(446, 326, 473, 217);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
			FechaSalida = new JDateChooser();
			FechaSalida.setBounds(22, 147, 107, 22);
			panel_1.add(FechaSalida);
			
			FechaLlegada = new JDateChooser();
			FechaLlegada.setBounds(22, 152, 107, 22);
			panel_2.add(FechaLlegada);
			
			textHoraSalida = new JTextField();
			textHoraSalida.setBounds(240, 147, 208, 20);
			panel_1.add(textHoraSalida);
			textHoraSalida.setColumns(10);

			textHoraLlegada = new JTextField();
			textHoraLlegada.setBounds(240, 152, 208, 20);
			panel_2.add(textHoraLlegada);
			textHoraLlegada.setColumns(10);
			
			textCiudadSalida = new JTextField();
			textCiudadSalida.setBounds(12, 100, 208, 20);
			panel_1.add(textCiudadSalida);
			textCiudadSalida.setColumns(10);
			
			textCiudadLlegada = new JTextField();
			textCiudadLlegada.setBounds(12, 95, 208, 20);
			panel_2.add(textCiudadLlegada);
			textCiudadLlegada.setColumns(10);
		
			textCantAsientos = new JTextField();
			textCantAsientos.setBounds(109, 99, 208, 22);
			panel.add(textCantAsientos);
			textCantAsientos.setColumns(10);
			
			textTiempoVuelo = new JTextField();
			textTiempoVuelo.setBounds(109, 146, 210, 22);
			panel.add(textTiempoVuelo);
			textTiempoVuelo.setColumns(10);

			
			comboBox_Aerolinea = new JComboBox<LineaAerea>();
			comboBox_Aerolinea.setBounds(109, 40, 233, 22);
			panel.add(comboBox_Aerolinea);
			comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
			
			comboBox_PaisSalida = new JComboBox<Pais>();
			comboBox_PaisSalida.setBounds(12, 39, 208, 20);
			panel_1.add(comboBox_PaisSalida);
			comboBox_PaisSalida.setModel(modelo);
			
			comboBox_ProvinciaSalida = new JComboBox<Provincia>();
			comboBox_ProvinciaSalida.setBounds(240, 37, 208, 22);
			panel_1.add(comboBox_ProvinciaSalida);
			comboBox_ProvinciaSalida.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
			
			comboBox_ProvinciaLlegada = new JComboBox<Provincia>();
			comboBox_ProvinciaLlegada.setBounds(240, 34, 208, 20);
			panel_2.add(comboBox_ProvinciaLlegada);
			comboBox_ProvinciaLlegada.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
			
			comboBox_PaisLlegada = new JComboBox<Pais>();
			comboBox_PaisLlegada.setBounds(12, 34, 208, 20);
			panel_2.add(comboBox_PaisLlegada);
			comboBox_PaisLlegada.setModel(modelo2);
			
			
			
			lblCantAsientos = new JLabel("Cantidad de Asientos");
			lblCantAsientos.setBounds(150, 121, 126, 16);
			panel.add(lblCantAsientos);
			
			lblTiempoVuelo = new JLabel("Tiempo de Vuelo");
			lblTiempoVuelo.setBounds(150, 168, 126, 16);
			panel.add(lblTiempoVuelo);
			
			JLabel label_9 = new JLabel("Aerolinea");
			label_9.setBounds(30, 40, 72, 16);
			panel.add(label_9);
			
			lblDatosBasicos = new JLabel("Datos Basicos");
			lblDatosBasicos.setBounds(30, 12, 221, 16);
			panel.add(lblDatosBasicos);
			
			lblFechaSalida = new JLabel("Fecha de Salida");
			lblFechaSalida.setBounds(28, 179, 126, 16);
			panel_1.add(lblFechaSalida);
			
			lblSalida = new JLabel("Salida");
			lblSalida.setBounds(12, 12, 221, 16);
			panel_1.add(lblSalida);
			
			lblPaisSalida = new JLabel("Pais");
			lblPaisSalida.setBounds(108, 62, 55, 16);
			panel_1.add(lblPaisSalida);
			
			lblProvinciaSalida = new JLabel("Provincia");
			lblProvinciaSalida.setBounds(322, 62, 55, 16);
			panel_1.add(lblProvinciaSalida);
			
			lblHoraSalida = new JLabel("Hora de Salida");
			lblHoraSalida.setBounds(307, 178, 113, 16);
			panel_1.add(lblHoraSalida);
			
			lblCiudadSalida = new JLabel("Ciudad");
			lblCiudadSalida.setBounds(99, 121, 55, 16);
			panel_1.add(lblCiudadSalida);
			
			lblPaisLlegada = new JLabel("Pais");
			lblPaisLlegada.setBounds(108, 57, 26, 16);
			panel_2.add(lblPaisLlegada);
			
			lblProvinciaLlegada = new JLabel("Provincia");
			lblProvinciaLlegada.setBounds(322, 57, 54, 16);
			panel_2.add(lblProvinciaLlegada);
			
			lblFechaLlegada = new JLabel("Fecha de Llegada");
			lblFechaLlegada.setBounds(32, 183, 122, 16);
			panel_2.add(lblFechaLlegada);
			
			lblLlegada = new JLabel("Llegada");
			lblLlegada.setBounds(12, 12, 221, 16);
			panel_2.add(lblLlegada);
			
			lblHoraLlegada = new JLabel("Hora de Llegada");
			lblHoraLlegada.setBounds(307, 183, 113, 16);
			panel_2.add(lblHoraLlegada);
			
			
			lblCiudadLlegada = new JLabel("Ciudad");
			lblCiudadLlegada.setBounds(99, 118, 55, 16);
			panel_2.add(lblCiudadLlegada);
			
			
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del vuelo para su alta");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(96, 33, 805, 55);
		getContentPane().add(lblIngreseLosDatos);
		this.setVisible(true);
	}
	
/**
 * @wbp.parser.constructor
 */
public Vuelo_Datos_Vista(Vuelo_Datos_Controller vista, Vuelo v) {

	this.vista = vista;
	setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	
    addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent evt) {
            close();
        }
    });
	setBounds(5, 53, 980, 694);
	setLocationRelativeTo(null);
	
	
	setTitle("Modificacion de Vuelo");
	getContentPane().setLayout(null);
	DefaultComboBoxModel<Pais> modelo2 = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());
	DefaultComboBoxModel<Pais> modelo = new DefaultComboBoxModel<Pais>(vista.obtenerListaPaises());
	
	btnGuardarMod = new JButton("Guardar");
	btnGuardarMod.addActionListener(new CapturaBtnVuelo_Datos(this));
	btnGuardarMod.setBounds(698, 601, 97, 25);
	getContentPane().add(btnGuardarMod);
	
	btnCancelar = new JButton("Cancelar");
	btnCancelar.addActionListener(new CapturaBtnVuelo_Datos(this));
	btnCancelar.setBounds(822, 602, 97, 25);
	getContentPane().add(btnCancelar);
	
	
	JLabel lblIngreseLosDatos = new JLabel("Modificacion de los datos del Vuelo");
	lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
	lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblIngreseLosDatos.setBounds(96, 33, 805, 55);
	getContentPane().add(lblIngreseLosDatos);
	
	JPanel panel = new JPanel();
	panel.setBounds(31, 78, 382, 217);
	getContentPane().add(panel);
	panel.setLayout(null);
	
	JPanel panel_1 = new JPanel();
	panel_1.setBounds(446, 78, 473, 217);
	getContentPane().add(panel_1);
	panel_1.setLayout(null);
	
	JPanel panel_2 = new JPanel();
	panel_2.setBounds(446, 326, 473, 217);
	getContentPane().add(panel_2);
	panel_2.setLayout(null);
	
		FechaSalida = new JDateChooser();
		FechaSalida.setBounds(22, 147, 107, 22);
		panel_1.add(FechaSalida);
		FechaSalida.setDate(v.getFechaHoraSalida());
		
		FechaLlegada = new JDateChooser();
		FechaLlegada.setBounds(22, 152, 107, 22);
		panel_2.add(FechaLlegada);
		FechaLlegada.setDate(v.getFechaHoraLlegada());
		
		textHoraSalida = new JTextField();
		textHoraSalida.setBounds(240, 147, 208, 20);
		panel_1.add(textHoraSalida);
		textHoraSalida.setColumns(10);

		textHoraLlegada = new JTextField();
		textHoraLlegada.setBounds(240, 152, 208, 20);
		panel_2.add(textHoraLlegada);
		textHoraLlegada.setColumns(10);
		
		textCiudadSalida = new JTextField();
		textCiudadSalida.setBounds(12, 100, 208, 20);
		panel_1.add(textCiudadSalida);
		textCiudadSalida.setColumns(10);
		
		textCiudadLlegada = new JTextField();
		textCiudadLlegada.setBounds(12, 95, 208, 20);
		panel_2.add(textCiudadLlegada);
		textCiudadLlegada.setColumns(10);
	
		textCantAsientos = new JTextField();
		textCantAsientos.setBounds(109, 99, 208, 22);
		panel.add(textCantAsientos);
		textCantAsientos.setColumns(10);
		
		textTiempoVuelo = new JTextField();
		textTiempoVuelo.setBounds(109, 146, 210, 22);
		panel.add(textTiempoVuelo);
		textTiempoVuelo.setColumns(10);

		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		comboBox_Aerolinea.setBounds(109, 40, 233, 22);
		panel.add(comboBox_Aerolinea);
		comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
		comboBox_Aerolinea.setSelectedIndex(vista.obtenerIndexAerolinea(comboBox_Aerolinea.getModel(), v));
		
		comboBox_PaisSalida = new JComboBox<Pais>();
		comboBox_PaisSalida.setBounds(12, 39, 208, 20);
		panel_1.add(comboBox_PaisSalida);
		comboBox_PaisSalida.setModel(modelo);
		comboBox_PaisSalida.setSelectedIndex(vista.obtenerIndexPais(comboBox_PaisSalida.getModel(),v));
		
		comboBox_ProvinciaSalida = new JComboBox<Provincia>();
		comboBox_ProvinciaSalida.setBounds(240, 37, 208, 22);
		panel_1.add(comboBox_ProvinciaSalida);
		comboBox_ProvinciaSalida.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
		comboBox_ProvinciaSalida.setSelectedIndex(vista.obtenerIndexProvincia(comboBox_ProvinciaLlegada.getModel(),v));
		
		comboBox_ProvinciaLlegada = new JComboBox<Provincia>();
		comboBox_ProvinciaLlegada.setBounds(240, 34, 208, 20);
		panel_2.add(comboBox_ProvinciaLlegada);
		comboBox_ProvinciaLlegada.setModel(new DefaultComboBoxModel<Provincia>(vista.obtenerListaProvincias()));
		comboBox_ProvinciaLlegada.setSelectedIndex(vista.obtenerIndexProvincia(comboBox_ProvinciaLlegada.getModel(),v));
		
		comboBox_PaisLlegada = new JComboBox<Pais>();
		comboBox_PaisLlegada.setBounds(12, 34, 208, 20);
		panel_2.add(comboBox_PaisLlegada);
		comboBox_PaisLlegada.setModel(modelo2);
		comboBox_PaisLlegada.setSelectedIndex(vista.obtenerIndexPais(comboBox_PaisLlegada.getModel(),v));
		
		
		
		lblCantAsientos = new JLabel("Cantidad de Asientos");
		lblCantAsientos.setBounds(150, 121, 126, 16);
		panel.add(lblCantAsientos);
		
		lblTiempoVuelo = new JLabel("Tiempo de Vuelo");
		lblTiempoVuelo.setBounds(150, 168, 126, 16);
		panel.add(lblTiempoVuelo);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setBounds(30, 40, 72, 16);
		panel.add(label_9);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(30, 12, 221, 16);
		panel.add(lblDatosBasicos);
		
		lblFechaSalida = new JLabel("Fecha de Salida");
		lblFechaSalida.setBounds(28, 179, 126, 16);
		panel_1.add(lblFechaSalida);
		
		lblSalida = new JLabel("Salida");
		lblSalida.setBounds(12, 12, 221, 16);
		panel_1.add(lblSalida);
		
		lblPaisSalida = new JLabel("Pais");
		lblPaisSalida.setBounds(108, 62, 55, 16);
		panel_1.add(lblPaisSalida);
		
		lblProvinciaSalida = new JLabel("Provincia");
		lblProvinciaSalida.setBounds(322, 62, 55, 16);
		panel_1.add(lblProvinciaSalida);
		
		lblHoraSalida = new JLabel("Hora de Salida");
		lblHoraSalida.setBounds(307, 178, 113, 16);
		panel_1.add(lblHoraSalida);
		
		lblCiudadSalida = new JLabel("Ciudad");
		lblCiudadSalida.setBounds(99, 121, 55, 16);
		panel_1.add(lblCiudadSalida);
		
		lblPaisLlegada = new JLabel("Pais");
		lblPaisLlegada.setBounds(108, 57, 26, 16);
		panel_2.add(lblPaisLlegada);
		
		lblProvinciaLlegada = new JLabel("Provincia");
		lblProvinciaLlegada.setBounds(322, 57, 54, 16);
		panel_2.add(lblProvinciaLlegada);
		
		lblFechaLlegada = new JLabel("Fecha de Llegada");
		lblFechaLlegada.setBounds(32, 183, 122, 16);
		panel_2.add(lblFechaLlegada);
		
		lblLlegada = new JLabel("Llegada");
		lblLlegada.setBounds(12, 12, 221, 16);
		panel_2.add(lblLlegada);
		
		lblHoraLlegada = new JLabel("Hora de Llegada");
		lblHoraLlegada.setBounds(307, 183, 113, 16);
		panel_2.add(lblHoraLlegada);
		
		
		lblCiudadLlegada = new JLabel("Ciudad");
		lblCiudadLlegada.setBounds(99, 118, 55, 16);
		panel_2.add(lblCiudadLlegada);
		this.setVisible(true);
	}

	
	public Vuelo_Datos_Controller getController() {
		return vista;
	}



	public void setController(Vuelo_Datos_Controller vista) {
		this.vista = vista;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}



	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}



	public JTextField getTextCiudadSalida() {
		return textCiudadSalida;
	}

	public void setTextCiudadSalida(JTextField textCiudadSalida) {
		this.textCiudadSalida = textCiudadSalida;
	}

	public JTextField getTextCiudadLlegada() {
		return textCiudadLlegada;
	}

	public void setTextCiudadLlegada(JTextField textCiudadLlegada) {
		this.textCiudadLlegada = textCiudadLlegada;
	}

	public Vuelo_Datos_Controller getVista() {
		return vista;
	}

	public void setVista(Vuelo_Datos_Controller vista) {
		this.vista = vista;
	}

	public JTextField getTextTiempoVuelo() {
		return textTiempoVuelo;
	}

	public void setTextTiempoVuelo(JTextField textTiempoVuelo) {
		this.textTiempoVuelo = textTiempoVuelo;
	}

	public JTextField getTextHoraSalida() {
		return textHoraSalida;
	}

	public void setTextHoraSalida(JTextField textHoraSalida) {
		this.textHoraSalida = textHoraSalida;
	}

	public JTextField getTextHoraLlegada() {
		return textHoraLlegada;
	}

	public void setTextHoraLlegada(JTextField textHoraLlegada) {
		this.textHoraLlegada = textHoraLlegada;
	}

	public JTextField getTextCantAsientos() {
		return textCantAsientos;
	}

	public void setTextCantAsientos(JTextField textCantAsientos) {
		this.textCantAsientos = textCantAsientos;
	}

	public JTextField getTextDNI() {
		return textTiempoVuelo;
	}

	public void setTextDNI(JTextField textDNI) {
		this.textTiempoVuelo = textDNI;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JComboBox<Pais> getComboBox_PaisLlegada() {
		return comboBox_PaisLlegada;
	}

	public void setComboBox_PaisLlegada(JComboBox<Pais> comboBox_PaisLlegada) {
		this.comboBox_PaisLlegada = comboBox_PaisLlegada;
	}

	public JComboBox<Provincia> getComboBox_ProvinciaLlegada() {
		return comboBox_ProvinciaLlegada;
	}

	public void setComboBox_ProvinciaLlegada(JComboBox<Provincia> comboBox_ProvinciaLlegada) {
		this.comboBox_ProvinciaLlegada = comboBox_ProvinciaLlegada;
	}

	
	public JTextField getTextAlianza() {
		return textAlianza;
	}

	public void setTextAlianza(JTextField textAlianza) {
		this.textAlianza = textAlianza;
	}

	public JDateChooser getFechaLlegada() {
		return FechaLlegada;
	}

	public void setFechaLlegada(JDateChooser fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}

	public JComboBox<LineaAerea> getComboBox_Aerolinea() {
		return comboBox_Aerolinea;
	}

	public JComboBox<Provincia> getComboBox_ProvinciaSalida() {
		return comboBox_ProvinciaSalida;
	}

	public void setComboBox_ProvinciaSalida(JComboBox<Provincia> comboBox_ProvinciaSalida) {
		this.comboBox_ProvinciaSalida = comboBox_ProvinciaSalida;
	}

	public void setComboBox_Aerolinea(JComboBox<LineaAerea> comboBox_Aerolinea) {
		this.comboBox_Aerolinea = comboBox_Aerolinea;
	}

	public JComboBox<Pais> getComboBox_PaisSalida() {
		return comboBox_PaisSalida;
	}

	public void setComboBox_PaisSalida(JComboBox<Pais> comboBox_PaisSalida) {
		this.comboBox_PaisSalida = comboBox_PaisSalida;
	}
	

	public JDateChooser getFechaSalida() {
		return FechaSalida;
	}

	public void setFechaSalida(JDateChooser fechaSalida) {
		FechaSalida = fechaSalida;
	}

	public JButton getBtnGuardarMod() {
		return btnGuardarMod;
	}

	public void setBtnGuardarMod(JButton btnGuardarMod) {
		this.btnGuardarMod = btnGuardarMod;
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
}