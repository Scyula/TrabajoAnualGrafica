package edu.usal.pantalla.vista.datos;

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
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.controller.datos.Vuelo_Datos_Controller;
import edu.usal.pantalla.vista.eventos.CapturaBtnVuelo_Datos;
@SuppressWarnings("deprecation")

public class Vuelo_Datos_Vista extends JFrame {
	public Vuelo_Datos_Vista() {
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	Vuelo_Datos_Controller vista;
	

	private JTextField textTiempoVuelo;
	
	private JButton btnGuardar;
	private JButton btnGuardarMod;
	private JButton btnCancelar;
	
	private JDateChooser dateSalida;
	private JDateChooser dateLlegada;
	
	private JComboBox<Aeropuerto> comboBox_AeropuertoSalida;
	private JComboBox<Aeropuerto> comboBox_AeropuertoLlegada;
	private JComboBox<LineaAerea> comboBox_Aerolinea;
	private JComboBox<String> comboBox_HoraSalida;
	private JComboBox<String> comboBox_MinutosSalida;
	private JComboBox<String> comboBox_HoraLlegada;
	private JComboBox<String> comboBox_MinutosLlegada;
	private JTextField textCantidadAsientos;
	private JTextField textRestantes;
	
/**
 * @wbp.parser.constructor
 */ 
	
	public Vuelo_Datos_Vista(Vuelo_Datos_Controller vista) {
		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		setBounds(5, 53, 742, 537);
		setLocationRelativeTo(null);
		
		setTitle("Alta de Vuelo");
		getContentPane().setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnVuelo_Datos(this));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnVuelo_Datos(this));
		btnCancelar.setBounds(615, 457, 97, 25);
		getContentPane().add(btnCancelar);
		btnGuardar.setBounds(491, 456, 97, 25);
		getContentPane().add(btnGuardar);

		JPanel panel = new JPanel();
		panel.setBounds(31, 78, 681, 99);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 188, 681, 104);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
	
		dateSalida = new JDateChooser();
		dateSalida.setBounds(391, 39, 107, 22);
		panel_1.add(dateSalida);
		
		textTiempoVuelo = new JTextField();
		textTiempoVuelo.setBounds(564, 40, 107, 22);
		panel.add(textTiempoVuelo);
		textTiempoVuelo.setColumns(10);
		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		comboBox_Aerolinea.setBounds(30, 40, 317, 22);
		comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
		panel.add(comboBox_Aerolinea);
		
		comboBox_AeropuertoSalida = new JComboBox<Aeropuerto>();
		comboBox_AeropuertoSalida.setBounds(32, 39, 311, 20);
		comboBox_AeropuertoSalida.setModel(new DefaultComboBoxModel<Aeropuerto>(vista.obtenerListaAeropuerto()));
		panel_1.add(comboBox_AeropuertoSalida);
		
		JLabel lblCantAsientos = new JLabel("Cantidad de Asientos");
		lblCantAsientos.setBounds(357, 66, 120, 16);
		panel.add(lblCantAsientos);
		
		JLabel lblTiempoVuelo = new JLabel("Tiempo de Vuelo");
		lblTiempoVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoVuelo.setBounds(564, 66, 107, 16);
		panel.add(lblTiempoVuelo);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(30, 66, 317, 16);
		panel.add(label_9);
		
		JLabel lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(30, 12, 221, 16);
		panel.add(lblDatosBasicos);
		
		JLabel lblFechaSalida = new JLabel("Fecha de Salida");
		lblFechaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSalida.setBounds(391, 71, 107, 16);
		panel_1.add(lblFechaSalida);
		
		textCantidadAsientos = new JTextField();
		textCantidadAsientos.setBounds(357, 41, 101, 20);
		panel.add(textCantidadAsientos);
		textCantidadAsientos.setColumns(10);
		
		textRestantes = new JTextField();
		textRestantes.setEditable(false);
		textRestantes.setBounds(468, 41, 67, 20);
		panel.add(textRestantes);
		textRestantes.setColumns(10);		
		
		JLabel lblRestantes_1 = new JLabel("Restantes");
		lblRestantes_1.setBounds(478, 66, 70, 16);
		panel.add(lblRestantes_1);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setBounds(12, 12, 221, 16);
		panel_1.add(lblSalida);
		
		JLabel lblPaisSalida = new JLabel("Aeropuerto");
		lblPaisSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisSalida.setBounds(32, 59, 311, 16);
		panel_1.add(lblPaisSalida);
		
		JLabel lblHoraSalida = new JLabel("Hora");
		lblHoraSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraSalida.setBounds(525, 71, 43, 16);
		panel_1.add(lblHoraSalida);
		
		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setBounds(589, 71, 43, 16);
		panel_1.add(lblMinutos);
		
		comboBox_HoraSalida = new JComboBox<String>();
		comboBox_HoraSalida.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_HoraSalida.setBounds(525, 41, 43, 20);
		panel_1.add(comboBox_HoraSalida);
		
		comboBox_MinutosSalida = new JComboBox<String>();
		comboBox_MinutosSalida.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_MinutosSalida.setBounds(589, 41, 43, 20);
		panel_1.add(comboBox_MinutosSalida);
			
			
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del vuelo para su alta");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(31, 11, 681, 55);
		getContentPane().add(lblIngreseLosDatos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(31, 303, 681, 142);
		getContentPane().add(panel_2);
		
		dateLlegada = new JDateChooser();
		dateLlegada.setBounds(391, 39, 107, 22);
		panel_2.add(dateLlegada);
		
		comboBox_HoraLlegada = new JComboBox<String>();
		comboBox_HoraLlegada.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_HoraLlegada.setBounds(525, 41, 43, 20);
		panel_2.add(comboBox_HoraLlegada);
		
		comboBox_MinutosLlegada = new JComboBox<String>();
		comboBox_MinutosLlegada.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_MinutosLlegada.setBounds(589, 41, 43, 20);
		panel_2.add(comboBox_MinutosLlegada);
		
		comboBox_AeropuertoLlegada = new JComboBox<Aeropuerto>();
		comboBox_AeropuertoLlegada.setBounds(33, 39, 309, 20);
		comboBox_AeropuertoLlegada.setModel(new DefaultComboBoxModel<Aeropuerto>(vista.obtenerListaAeropuerto()));
		panel_2.add(comboBox_AeropuertoLlegada);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada");
		lblFechaDeLlegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeLlegada.setBounds(391, 71, 107, 16);
		panel_2.add(lblFechaDeLlegada);
		
		JLabel lblLlegada = new JLabel("Llegada");
		lblLlegada.setBounds(12, 12, 221, 16);
		panel_2.add(lblLlegada);
		
		JLabel label_2 = new JLabel("Aeropuerto");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(33, 62, 309, 16);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Hora");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(525, 71, 43, 16);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Minutos");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(588, 71, 43, 16);
		panel_2.add(label_4);
		this.setVisible(true);
	}

	public Vuelo_Datos_Vista(Vuelo_Datos_Controller vista, Vuelo v) {
		this.vista = vista;
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		setBounds(5, 53, 742, 537);
		setLocationRelativeTo(null);
		
		setTitle("Alta de Vuelo");
		getContentPane().setLayout(null);
		
		btnGuardarMod = new JButton("Guardar");
		btnGuardarMod.addActionListener(new CapturaBtnVuelo_Datos(this));
		btnGuardarMod.setBounds(491, 456, 97, 25);
		getContentPane().add(btnGuardarMod);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new CapturaBtnVuelo_Datos(this));
		btnCancelar.setBounds(615, 457, 97, 25);
		getContentPane().add(btnCancelar);

		JPanel panel = new JPanel();
		panel.setBounds(31, 78, 681, 99);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 188, 681, 104);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
	
		dateSalida = new JDateChooser();
		dateSalida.setBounds(391, 39, 107, 22);
		dateSalida.setDate(v.getFechaHoraSalida());
		panel_1.add(dateSalida);
		
		textTiempoVuelo = new JTextField(v.getTiempoVuelo());
		textTiempoVuelo.setBounds(564, 40, 107, 22);
		panel.add(textTiempoVuelo);
		textTiempoVuelo.setColumns(10);
		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		comboBox_Aerolinea.setBounds(30, 40, 317, 22);
		comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.obtenerListaAerolinea()));
		comboBox_Aerolinea.setSelectedIndex(vista.obtenerIndexAerolinea(comboBox_Aerolinea.getModel(), v));
		panel.add(comboBox_Aerolinea);
		
		comboBox_AeropuertoSalida = new JComboBox<Aeropuerto>();
		comboBox_AeropuertoSalida.setBounds(32, 39, 311, 20);
		comboBox_AeropuertoSalida.setModel(new DefaultComboBoxModel<Aeropuerto>(vista.obtenerListaAeropuerto()));
		comboBox_AeropuertoSalida.setSelectedIndex(vista.obtenerIndexAeropuerto(comboBox_AeropuertoSalida.getModel(), v.getAeroSalida()));
		panel_1.add(comboBox_AeropuertoSalida);
		
		JLabel lblCantAsientos = new JLabel("Cantidad de Asientos");
		lblCantAsientos.setBounds(357, 66, 120, 16);
		panel.add(lblCantAsientos);
		
		JLabel lblTiempoVuelo = new JLabel("Tiempo de Vuelo");
		lblTiempoVuelo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempoVuelo.setBounds(564, 66, 107, 16);
		panel.add(lblTiempoVuelo);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(30, 66, 317, 16);
		panel.add(label_9);
		
		JLabel lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(30, 12, 221, 16);
		panel.add(lblDatosBasicos);
		
		textCantidadAsientos = new JTextField(String.valueOf(v.getCantAsientos()));
		textCantidadAsientos.setBounds(376, 41, 101, 20);
		panel.add(textCantidadAsientos);
		textCantidadAsientos.setColumns(10);
		
		textRestantes = new JTextField(String.valueOf(v.getAsientosDisponibles()));
		textRestantes.setEditable(false);
		textRestantes.setBounds(487, 41, 67, 20);
		panel.add(textRestantes);
		textRestantes.setColumns(10);
		
		JLabel lblRestantes = new JLabel("Restantes");
		lblRestantes.setBounds(487, 67, 67, 16);
		panel.add(lblRestantes);
		
		JLabel lblFechaSalida = new JLabel("Fecha de Salida");
		lblFechaSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaSalida.setBounds(391, 71, 107, 16);
		panel_1.add(lblFechaSalida);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setBounds(12, 12, 221, 16);
		panel_1.add(lblSalida);
		
		JLabel lblPaisSalida = new JLabel("Aeropuerto");
		lblPaisSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaisSalida.setBounds(32, 59, 311, 16);
		panel_1.add(lblPaisSalida);
		
		JLabel lblHoraSalida = new JLabel("Hora");
		lblHoraSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraSalida.setBounds(525, 71, 43, 16);
		panel_1.add(lblHoraSalida);
		
		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutos.setBounds(589, 71, 43, 16);
		panel_1.add(lblMinutos);
		
		comboBox_HoraSalida = new JComboBox<String>();
		comboBox_HoraSalida.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_HoraSalida.setBounds(525, 41, 43, 20);
		comboBox_HoraSalida.setSelectedIndex(v.getFechaHoraSalida().getHours());
		panel_1.add(comboBox_HoraSalida);
		
		comboBox_MinutosSalida = new JComboBox<String>();
		comboBox_MinutosSalida.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_MinutosSalida.setBounds(589, 41, 43, 20);
		comboBox_MinutosSalida.setSelectedIndex(v.getFechaHoraSalida().getMinutes());
		panel_1.add(comboBox_MinutosSalida);
			
			
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos del vuelo para su alta");
		lblIngreseLosDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngreseLosDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblIngreseLosDatos.setBounds(31, 11, 681, 55);
		getContentPane().add(lblIngreseLosDatos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(31, 303, 681, 142);
		getContentPane().add(panel_2);
		
		dateLlegada = new JDateChooser();
		dateLlegada.setBounds(391, 39, 107, 22);
		dateLlegada.setDate(v.getFechaHoraLlegada());
		panel_2.add(dateLlegada);
		
		comboBox_HoraLlegada = new JComboBox<String>();
		comboBox_HoraLlegada.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_HoraLlegada.setBounds(525, 41, 43, 20);
		comboBox_HoraLlegada.setSelectedIndex(v.getFechaHoraLlegada().getHours());
		panel_2.add(comboBox_HoraLlegada);
		
		comboBox_MinutosLlegada = new JComboBox<String>();
		comboBox_MinutosLlegada.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		comboBox_MinutosLlegada.setBounds(589, 41, 43, 20);
		comboBox_MinutosLlegada.setSelectedIndex(v.getFechaHoraLlegada().getMinutes());
		panel_2.add(comboBox_MinutosLlegada);
		
		comboBox_AeropuertoLlegada = new JComboBox<Aeropuerto>();
		comboBox_AeropuertoLlegada.setBounds(33, 39, 309, 20);
		comboBox_AeropuertoLlegada.setModel(new DefaultComboBoxModel<Aeropuerto>(vista.obtenerListaAeropuerto()));
		comboBox_AeropuertoLlegada.setSelectedIndex(vista.obtenerIndexAeropuerto(comboBox_AeropuertoLlegada.getModel(), v.getAeroLlegada()));
		panel_2.add(comboBox_AeropuertoLlegada);
		
		JLabel lblFechaDeLlegada = new JLabel("Fecha de Llegada");
		lblFechaDeLlegada.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaDeLlegada.setBounds(391, 71, 107, 16);
		panel_2.add(lblFechaDeLlegada);
		
		JLabel lblLlegada = new JLabel("Llegada");
		lblLlegada.setBounds(12, 12, 221, 16);
		panel_2.add(lblLlegada);
		
		JLabel label_2 = new JLabel("Aeropuerto");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(33, 62, 309, 16);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Hora");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(525, 71, 43, 16);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Minutos");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(588, 71, 43, 16);
		panel_2.add(label_4);
		this.setVisible(true);
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

public JButton getBtnGuardar() {
	return btnGuardar;
}

public void setBtnGuardar(JButton btnGuardar) {
	this.btnGuardar = btnGuardar;
}

public JButton getBtnGuardarMod() {
	return btnGuardarMod;
}

public void setBtnGuardarMod(JButton btnGuardarMod) {
	this.btnGuardarMod = btnGuardarMod;
}

public JButton getBtnCancelar() {
	return btnCancelar;
}

public void setBtnCancelar(JButton btnCancelar) {
	this.btnCancelar = btnCancelar;
}

public JDateChooser getDateSalida() {
	return dateSalida;
}

public void setDateSalida(JDateChooser dateSalida) {
	this.dateSalida = dateSalida;
}

public JDateChooser getDateLlegada() {
	return dateLlegada;
}

public void setDateLlegada(JDateChooser dateLlegada) {
	this.dateLlegada = dateLlegada;
}

public JComboBox<Aeropuerto> getComboBox_AeropuertoSalida() {
	return comboBox_AeropuertoSalida;
}

public void setComboBox_AeropuertoSalida(JComboBox<Aeropuerto> comboBox_AeropuertoSalida) {
	this.comboBox_AeropuertoSalida = comboBox_AeropuertoSalida;
}

public JComboBox<Aeropuerto> getComboBox_AeropuertoLlegada() {
	return comboBox_AeropuertoLlegada;
}

public void setComboBox_AeropuertoLlegada(JComboBox<Aeropuerto> comboBox_AeropuertoLlegada) {
	this.comboBox_AeropuertoLlegada = comboBox_AeropuertoLlegada;
}

public JComboBox<LineaAerea> getComboBox_Aerolinea() {
	return comboBox_Aerolinea;
}

public void setComboBox_Aerolinea(JComboBox<LineaAerea> comboBox_Aerolinea) {
	this.comboBox_Aerolinea = comboBox_Aerolinea;
}

public JComboBox<String> getComboBox_HoraSalida() {
	return comboBox_HoraSalida;
}

public void setComboBox_HoraSalida(JComboBox<String> comboBox_HoraSalida) {
	this.comboBox_HoraSalida = comboBox_HoraSalida;
}

public JComboBox<String> getComboBox_MinutosSalida() {
	return comboBox_MinutosSalida;
}

public void setComboBox_MinutosSalida(JComboBox<String> comboBox_MinutosSalida) {
	this.comboBox_MinutosSalida = comboBox_MinutosSalida;
}

public JComboBox<String> getComboBox_HoraLlegada() {
	return comboBox_HoraLlegada;
}

public void setComboBox_HoraLlegada(JComboBox<String> comboBox_HoraLlegada) {
	this.comboBox_HoraLlegada = comboBox_HoraLlegada;
}

public JComboBox<String> getComboBox_MinutosLlegada() {
	return comboBox_MinutosLlegada;
}

public void setComboBox_MinutosLlegada(JComboBox<String> comboBox_MinutosLlegada) {
	this.comboBox_MinutosLlegada = comboBox_MinutosLlegada;
}

public JTextField getTextCantidadAsientos() {
	return textCantidadAsientos;
}

public void setTextCantidadAsientos(JTextField spinCantidadAsientos) {
	this.textCantidadAsientos = spinCantidadAsientos;
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

	public void errorCarga() {
		JOptionPane.showMessageDialog(null, "Error en la carga de datos, verifique los archivos de la carpeta \"recursos/txt\"", "", JOptionPane.WARNING_MESSAGE);
	} 
}