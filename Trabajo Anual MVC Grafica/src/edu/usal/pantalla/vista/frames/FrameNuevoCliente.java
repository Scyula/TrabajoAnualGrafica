package edu.usal.pantalla.vista.frames;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.pantalla.vista.GestionClienteVista;
import edu.usal.pantalla.vista.eventos.CapturaBtnNuevoCliente;

import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

public class FrameNuevoCliente extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GestionClienteVista vista;
	
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField textEmail;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDNI;
	private JButton btnGuardar;
	private JLabel label_8;
	private JLabel lblPais;
	private JLabel lblCiudad;
	private JLabel lblCiudad_1;
	private JTextField textCiudad;
	private JLabel lblCodigoPostal;
	private JTextField textCodPostal;
	private JLabel lblCalle;
	private JTextField textCalle;
	private JLabel lblAltura;
	private JTextField textAltura;
	private JLabel label;
	private JTextField textTelCelular;
	private JTextField textTelLaboral;
	private JTextField textTelPersonal;
	private JTextField textNroPasaporte;
	private JTextField textAutoridadEmision;
	private JTextField textNroPasajero;
	private JTextField textCategoria;
	private JLabel lblPasajeroFrecuente;
	private JLabel lblPasaporte;
	private JLabel lblDatosBasicos;
	private JLabel lblTelefono;
	private JLabel lblDireccion;
	private JTextField textCuit;
	private JComboBox<Pais> comboBox_Pais;
	private JComboBox<Provincia> comboBox_Provincia;
	private JComboBox<Pais> comboBox_PaisEmision;
	private JComboBox<LineaAerea> comboBox_Aerolinea;
	private JLabel label_13;
	private JLabel label_15;
	private JComboBox<String> comboBox_FechaVencYYYY;
	private JComboBox<String> comboBox_FechaVencDD;
	private JComboBox<String> comboBox_FechaVencMM;
	private JComboBox<String> comboBox_FechaNacDD;
	private JComboBox<String> comboBox_FechaNacYYYY;
	private JComboBox<String> comboBox_FechaNacMM;
	private JComboBox<String> comboBox_FechaEmiMM;
	private JComboBox<String> comboBox_FechaEmiDD;
	private JComboBox<String> comboBox_FechaEmiYYYY;
	
	
	public FrameNuevoCliente(GestionClienteVista vista) {
		
		this.vista = vista;
		
		
		setBounds(5, 53, 969, 590);
		setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(106, 65, 37, 16);
		this.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(334, 65, 37, 16);
		this.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(106, 112, 126, 16);
		this.add(lblDni);
		
		label_4 = new JLabel("Fecha de Nacimiento");
		label_4.setBounds(34, 165, 126, 16);
		this.add(label_4);
		
		label_5 = new JLabel("E-mail");
		label_5.setBounds(334, 112, 35, 16);
		this.add(label_5);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(252, 92, 208, 22);
		this.add(textEmail);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(24, 43, 208, 22);
		this.add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(252, 43, 208, 22);
		this.add(textApellido);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(24, 90, 210, 22);
		this.add(textDNI);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new CapturaBtnNuevoCliente(this));
		btnGuardar.setBounds(437, 552, 97, 25);
		this.add(btnGuardar);

		label_8 = new JLabel("-");
		label_8.setBounds(143, 139, 17, 16);
		this.add(label_8);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(120, 380, 26, 16);
		this.add(lblPais);
		
		lblCiudad = new JLabel("Provincia");
		lblCiudad.setBounds(334, 380, 54, 16);
		this.add(lblCiudad);
		
		lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(106, 426, 37, 16);
		this.add(lblCiudad_1);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBounds(24, 402, 208, 22);
		this.add(textCiudad);
		
		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(273, 426, 73, 16);
		this.add(lblCodigoPostal);
		
		textCodPostal = new JTextField();
		textCodPostal.setColumns(10);
		textCodPostal.setBounds(252, 402, 107, 22);
		this.add(textCodPostal);
		
		lblCalle = new JLabel("Calle");
		lblCalle.setBounds(117, 476, 26, 16);
		this.add(lblCalle);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(24, 452, 208, 22);
		this.add(textCalle);
		
		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(287, 476, 37, 16);
		this.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(252, 452, 107, 22);
		this.add(textAltura);
		
		label = new JLabel("-");
		label.setBounds(77, 138, 17, 16);
		this.add(label);
		
		textTelCelular = new JTextField();
		textTelCelular.setColumns(10);
		textTelCelular.setBounds(252, 219, 208, 22);
		this.add(textTelCelular);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular");
		lblTelCelular.setBounds(334, 243, 54, 16);
		this.add(lblTelCelular);
		
		textTelLaboral = new JTextField();
		textTelLaboral.setColumns(10);
		textTelLaboral.setBounds(24, 272, 208, 22);
		this.add(textTelLaboral);
		
		JLabel lblTelLaboral = new JLabel("Tel. Laboral");
		lblTelLaboral.setBounds(81, 296, 97, 16);
		this.add(lblTelLaboral);
		
		textTelPersonal = new JTextField();
		textTelPersonal.setColumns(10);
		textTelPersonal.setBounds(24, 219, 208, 22);
		this.add(textTelPersonal);
		
		JLabel lblTelPersonal = new JLabel("Tel. Personal");
		lblTelPersonal.setBounds(81, 243, 97, 16);
		this.add(lblTelPersonal);
		
		JLabel label_1 = new JLabel("Numero de Pasaporte");
		label_1.setBounds(570, 65, 126, 16);
		this.add(label_1);
		
		JLabel label_2 = new JLabel("Autoridad de Emision");
		label_2.setBounds(803, 65, 126, 16);
		this.add(label_2);
		
		JLabel label_3 = new JLabel("Fecha de Emision");
		label_3.setBounds(536, 122, 126, 16);
		this.add(label_3);
		
		JLabel label_6 = new JLabel("Pais de Emision");
		label_6.setBounds(815, 115, 78, 16);
		this.add(label_6);
		
		textNroPasaporte = new JTextField();
		textNroPasaporte.setColumns(10);
		textNroPasaporte.setBounds(536, 43, 198, 22);
		this.add(textNroPasaporte);
		
		textAutoridadEmision = new JTextField();
		textAutoridadEmision.setColumns(10);
		textAutoridadEmision.setBounds(753, 43, 199, 22);
		this.add(textAutoridadEmision);
		
		JLabel label_9 = new JLabel("Aerolinea");
		label_9.setBounds(617, 335, 47, 16);
		this.add(label_9);
		
		JLabel label_10 = new JLabel("Alianza");
		label_10.setBounds(636, 414, 45, 16);
		this.add(label_10);
		
		JLabel lblNumeroPasajero = new JLabel("Numero Pasajero");
		lblNumeroPasajero.setBounds(596, 296, 85, 16);
		this.add(lblNumeroPasajero);
		
		textNroPasajero = new JTextField();
		textNroPasajero.setColumns(10);
		textNroPasajero.setBounds(536, 275, 198, 22);
		this.add(textNroPasajero);
		
		JLabel label_12 = new JLabel("Categoria");
		label_12.setBounds(826, 296, 54, 16);
		this.add(label_12);
		
		textCategoria = new JTextField();
		textCategoria.setColumns(10);
		textCategoria.setBounds(753, 275, 199, 22);
		this.add(textCategoria);
		
		JLabel label_14 = new JLabel("Fecha de Vencimiento");
		label_14.setBounds(536, 197, 126, 16);
		this.add(label_14);
		
		JRadioButton radioButton_Skyteam = new JRadioButton("Skyteam");
		radioButton_Skyteam.setBounds(745, 367, 127, 25);
		
		
		JRadioButton radioButton_OneWorld = new JRadioButton("Oneworld");
		radioButton_OneWorld.setBounds(745, 410, 127, 25);
		
		
		JRadioButton radioButton_StarAlliance = new JRadioButton("Star Alliance");
		radioButton_StarAlliance.setBounds(745, 458, 127, 25);
		
		ButtonGroup grupoAlianza = new ButtonGroup();
		grupoAlianza.add(radioButton_OneWorld);
		grupoAlianza.add(radioButton_Skyteam);
		grupoAlianza.add(radioButton_StarAlliance);
		
		this.add(radioButton_OneWorld);
		this.add(radioButton_Skyteam);
		this.add(radioButton_StarAlliance);
		
		lblPasajeroFrecuente = new JLabel("Pasajero Frecuente");
		lblPasajeroFrecuente.setBounds(526, 247, 221, 17);
		this.add(lblPasajeroFrecuente);
		
		lblPasaporte = new JLabel("Pasaporte");
		lblPasaporte.setBounds(536, 12, 138, 16);
		this.add(lblPasaporte);
		
		lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setBounds(24, 12, 221, 16);
		this.add(lblDatosBasicos);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(24, 197, 221, 16);
		this.add(lblTelefono);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(24, 335, 221, 16);
		this.add(lblDireccion);
		
		JLabel lblCuitcuil = new JLabel("CUIT/CUIL");
		lblCuitcuil.setBounds(316, 166, 72, 14);
		add(lblCuitcuil);
		
		comboBox_Pais = new JComboBox<Pais>();
		comboBox_Pais.setBounds(24, 357, 208, 20);
		comboBox_Pais.setModel(new DefaultComboBoxModel<Pais>(vista.getClienteController().obtenerListaPaises()));
		add(comboBox_Pais);
		
		comboBox_Provincia = new JComboBox<Provincia>();
		comboBox_Provincia.setBounds(252, 357, 208, 20);
		comboBox_Provincia.setModel(new DefaultComboBoxModel<Provincia>(vista.getClienteController().obtenerListaProvincias()));
		add(comboBox_Provincia);
		
		comboBox_PaisEmision = new JComboBox<Pais>();
		comboBox_PaisEmision.setModel(new DefaultComboBoxModel<Pais>(vista.getClienteController().obtenerListaPaises()));
		comboBox_PaisEmision.setBounds(753, 93, 199, 20);
		add(comboBox_PaisEmision);
		
		comboBox_Aerolinea = new JComboBox<LineaAerea>();
		comboBox_Aerolinea.setModel(new DefaultComboBoxModel<LineaAerea>(vista.getClienteController().obtenerListaAerolinea()));
		comboBox_Aerolinea.setBounds(696, 335, 172, 22);
		add(comboBox_Aerolinea);
		
		comboBox_FechaNacYYYY = new JComboBox();
		comboBox_FechaNacYYYY.setModel(new DefaultComboBoxModel(new String[] {"YYYY", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		comboBox_FechaNacYYYY.setBounds(157, 134, 62, 20);
		add(comboBox_FechaNacYYYY);
		
		comboBox_FechaNacDD = new JComboBox<String>();
		comboBox_FechaNacDD.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_FechaNacDD.setBounds(24, 134, 47, 20);
		add(comboBox_FechaNacDD);
		
		comboBox_FechaNacMM = new JComboBox<String>();
		comboBox_FechaNacMM.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_FechaNacMM.setBounds(89, 134, 47, 20);
		add(comboBox_FechaNacMM);
		
		comboBox_FechaEmiYYYY = new JComboBox<String>();
		comboBox_FechaEmiYYYY.setModel(new DefaultComboBoxModel(new String[] {"YYYY", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		comboBox_FechaEmiYYYY.setBounds(672, 93, 62, 20);
		add(comboBox_FechaEmiYYYY);
		
		comboBox_FechaEmiDD = new JComboBox<String>();
		comboBox_FechaEmiDD.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_FechaEmiDD.setBounds(539, 93, 47, 20);
		add(comboBox_FechaEmiDD);
		
		comboBox_FechaEmiMM = new JComboBox<String>();
		comboBox_FechaEmiMM.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_FechaEmiMM.setBounds(604, 93, 47, 20);
		add(comboBox_FechaEmiMM);
		
		comboBox_FechaVencYYYY = new JComboBox<String>();
		comboBox_FechaVencYYYY.setModel(new DefaultComboBoxModel(new String[] {"YYYY", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050"}));
		comboBox_FechaVencYYYY.setBounds(672, 166, 62, 20);
		add(comboBox_FechaVencYYYY);
		
		comboBox_FechaVencDD = new JComboBox<String>();
		comboBox_FechaVencDD.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_FechaVencDD.setBounds(539, 166, 47, 20);
		add(comboBox_FechaVencDD);
		
		comboBox_FechaVencMM = new JComboBox<String>();
		comboBox_FechaVencMM.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox_FechaVencMM.setBounds(604, 166, 47, 20);
		add(comboBox_FechaVencMM);
		
		textCuit = new JTextField();
		textCuit.setBounds(252, 140, 208, 20);
		add(textCuit);
		textCuit.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 335, 476, 177);
		this.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 197, 476, 139);
		this.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(510, 247, 449, 265);
		this.add(separator_2);
		
		JLabel label_7 = new JLabel("-");
		label_7.setBounds(658, 98, 17, 16);
		add(label_7);
		
		JLabel label_11 = new JLabel("-");
		label_11.setBounds(592, 97, 17, 16);
		add(label_11);
		
		label_13 = new JLabel("-");
		label_13.setBounds(658, 171, 17, 16);
		add(label_13);
		
		label_15 = new JLabel("-");
		label_15.setBounds(592, 170, 17, 16);
		add(label_15);
		this.setVisible(false);
	}


	public JTextField getTextEmail() {
		return textEmail;
	}


	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}


	public JTextField getTextNombre() {
		return textNombre;
	}


	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}


	public JTextField getTextApellido() {
		return textApellido;
	}


	public void setTextApellido(JTextField textApellido) {
		this.textApellido = textApellido;
	}

	public JTextField getTextDNI() {
		return textDNI;
	}


	public void setTextDNI(JTextField textDNI) {
		this.textDNI = textDNI;
	}


	public JTextField getTextCuit() {
		return textCuit;
	}


	public void setTextCuit(JTextField textCuit) {
		this.textCuit = textCuit;
	}


	public GestionClienteVista getVista() {
		return vista;
	}


	public void setVista(GestionClienteVista vista) {
		this.vista = vista;
	}


	public JButton getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JTextField getTextCiudad() {
		return textCiudad;
	}


	public void setTextCiudad(JTextField textCiudad) {
		this.textCiudad = textCiudad;
	}


	public JTextField getTextCodPostal() {
		return textCodPostal;
	}


	public void setTextCodPostal(JTextField textCodPostal) {
		this.textCodPostal = textCodPostal;
	}


	public JTextField getTextCalle() {
		return textCalle;
	}


	public void setTextCalle(JTextField textCalle) {
		this.textCalle = textCalle;
	}


	public JTextField getTextAltura() {
		return textAltura;
	}


	public void setTextAltura(JTextField textAltura) {
		this.textAltura = textAltura;
	}


	public JTextField getTextTelCelular() {
		return textTelCelular;
	}


	public void setTextTelCelular(JTextField textTelCelular) {
		this.textTelCelular = textTelCelular;
	}


	public JTextField getTextTelLaboral() {
		return textTelLaboral;
	}


	public void setTextTelLaboral(JTextField textTelLaboral) {
		this.textTelLaboral = textTelLaboral;
	}


	public JTextField getTextTelPersonal() {
		return textTelPersonal;
	}


	public void setTextTelPersonal(JTextField textTelPersonal) {
		this.textTelPersonal = textTelPersonal;
	}


	public JTextField getTextNroPasaporte() {
		return textNroPasaporte;
	}


	public void setTextNroPasaporte(JTextField textNroPasaporte) {
		this.textNroPasaporte = textNroPasaporte;
	}


	public JTextField getTextAutoridadEmision() {
		return textAutoridadEmision;
	}


	public void setTextAutoridadEmision(JTextField textAutoridadEmision) {
		this.textAutoridadEmision = textAutoridadEmision;
	}


	public JTextField getTextNroPasajero() {
		return textNroPasajero;
	}


	public void setTextNroPasajero(JTextField textNroPasajero) {
		this.textNroPasajero = textNroPasajero;
	}


	public JTextField getTextCategoria() {
		return textCategoria;
	}


	public void setTextCategoria(JTextField textCategoria) {
		this.textCategoria = textCategoria;
	}


	public JComboBox<Pais> getComboBox_Pais() {
		return comboBox_Pais;
	}


	public void setComboBox_Pais(JComboBox<Pais> comboBox_Pais) {
		this.comboBox_Pais = comboBox_Pais;
	}


	public JComboBox<Provincia> getComboBox_Provincia() {
		return comboBox_Provincia;
	}


	public void setComboBox_Provincia(JComboBox<Provincia> comboBox_Provincia) {
		this.comboBox_Provincia = comboBox_Provincia;
	}


	public JComboBox<Pais> getComboBox_PaisEmision() {
		return comboBox_PaisEmision;
	}


	public void setComboBox_PaisEmision(JComboBox<Pais> comboBox_PaisEmision) {
		this.comboBox_PaisEmision = comboBox_PaisEmision;
	}


	public JComboBox<LineaAerea> getComboBox_Aerolinea() {
		return comboBox_Aerolinea;
	}


	public void setComboBox_Aerolinea(JComboBox<LineaAerea> comboBox_Aerolinea) {
		this.comboBox_Aerolinea = comboBox_Aerolinea;
	}


	public JComboBox<String> getComboBox_FechaVencYYYY() {
		return comboBox_FechaVencYYYY;
	}


	public void setComboBox_FechaVencYYYY(JComboBox<String> comboBox_FechaVencYYYY) {
		this.comboBox_FechaVencYYYY = comboBox_FechaVencYYYY;
	}


	public JComboBox<String> getComboBox_FechaVencDD() {
		return comboBox_FechaVencDD;
	}


	public void setComboBox_FechaVencDD(JComboBox<String> comboBox_FechaVencDD) {
		this.comboBox_FechaVencDD = comboBox_FechaVencDD;
	}


	public JComboBox<String> getComboBox_FechaVencMM() {
		return comboBox_FechaVencMM;
	}


	public void setComboBox_FechaVencMM(JComboBox<String> comboBox_FechaVencMM) {
		this.comboBox_FechaVencMM = comboBox_FechaVencMM;
	}


	public JComboBox<String> getComboBox_FechaNacDD() {
		return comboBox_FechaNacDD;
	}


	public void setComboBox_FechaNacDD(JComboBox<String> comboBox_FechaNacDD) {
		this.comboBox_FechaNacDD = comboBox_FechaNacDD;
	}


	public JComboBox<String> getComboBox_FechaNacYYYY() {
		return comboBox_FechaNacYYYY;
	}


	public void setComboBox_FechaNacYYYY(JComboBox<String> comboBox_FechaNacYYYY) {
		this.comboBox_FechaNacYYYY = comboBox_FechaNacYYYY;
	}


	public JComboBox<String> getComboBox_FechaNacMM() {
		return comboBox_FechaNacMM;
	}


	public void setComboBox_FechaNacMM(JComboBox<String> comboBox_FechaNacMM) {
		this.comboBox_FechaNacMM = comboBox_FechaNacMM;
	}


	public JComboBox<String> getComboBox_FechaEmiMM() {
		return comboBox_FechaEmiMM;
	}


	public void setComboBox_FechaEmiMM(JComboBox<String> comboBox_FechaEmiMM) {
		this.comboBox_FechaEmiMM = comboBox_FechaEmiMM;
	}


	public JComboBox<String> getComboBox_FechaEmiDD() {
		return comboBox_FechaEmiDD;
	}


	public void setComboBox_FechaEmiDD(JComboBox<String> comboBox_FechaEmiDD) {
		this.comboBox_FechaEmiDD = comboBox_FechaEmiDD;
	}


	public JComboBox<String> getComboBox_FechaEmiYYYY() {
		return comboBox_FechaEmiYYYY;
	}


	public void setComboBox_FechaEmiYYYY(JComboBox<String> comboBox_FechaEmiYYYY) {
		this.comboBox_FechaEmiYYYY = comboBox_FechaEmiYYYY;
	}
	
}
