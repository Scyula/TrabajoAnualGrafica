package edu.usal.pantalla.vista;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.pantalla.controller.MenuPrincipalControllerTabla;
import edu.usal.pantalla.vista.eventos.CapturaBtnMP_Tabla;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

public class MenuPrincipalVista__Tabla extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MenuPrincipalControllerTabla mpController;
	
	private JPanel contentPane;
	private JTable table;
	
	private JPanel panel_Botones;
	private JPanel panel_Modificar;
	private JPanel panel_Agregar;
	private JPanel panel_Eliminar;
	private JPanel panel_Ver;
	
	private JButton btnClientes;
	private JButton btnAerolineas;
	private JButton btnVuelos;
	private JButton btnVenta;

	private JButton btnModCliente = new JButton("Modificar");
	private JButton btnAddCliente = new JButton("Nuevo");
	private JButton btnDelCliente = new JButton("Eliminar");
	
	
	private JButton btnModAerolinea= new JButton("Modificar");
	private JButton btnAddAerolinea = new JButton("Nuevo");
	private JButton btnDelAerolinea = new JButton("Eliminar");
	private JButton btnVerVuelos = new JButton("Ver Vuelos");
	

	private JButton btnModVuelo = new JButton("Modificar");
	private JButton btnAddVuelo = new JButton("Nuevo");
	private JButton btnDelVuelo = new JButton("Eliminar");
	private JButton btnVerClientes = new JButton("Ver Clientes");
	

	private JButton btnModVenta = new JButton("Modificar");
	private JButton btnAddVenta = new JButton("Nuevo");
	private JButton btnDelVenta = new JButton("Eliminar");
	
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_5;
	private JPanel panel_7;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JPanel panel_34;
	private JPanel panel_35;
	private JPanel panel_40;
	private JPanel panel_41;
	private JPanel panel_42;
	private JPanel panel_43;
	private JPanel panel_44;
	private JPanel panel_45;
	private JPanel panel_46;
	private JPanel panel_47;
	private JPanel panel_48;
	private JPanel panel_49;
	private JPanel panel_50;
	private JPanel panel_51;
	private JPanel panel_52;
	private JPanel panel_53;
	private JPanel panel_54;
	private JButton btnBuscar;
	private JPanel panel_55;
	private JPanel panel_56;
	private JPanel panel_57;
	private JPanel panel_58;
	private JPanel panel_59;
	private JPanel panel_60;
	private JPanel panel_61;
	private JPanel panel_62;
	private JLabel lblSeleccioneCampo;
	private JLabel lblBusqueda;
	private JComboBox<String> comboBox_Busqueda;
	private JTextField textBuscar;
	

	public MenuPrincipalControllerTabla getMpController() {
		return mpController;
	}

	public void setMpController(MenuPrincipalControllerTabla mpController) {
		this.mpController = mpController;
	}

	public MenuPrincipalVista__Tabla(MenuPrincipalControllerTabla mpController) {
		this.mpController = mpController;
		
		setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
		 
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                close();
            }
        });
		setBounds(100, 100, 1208, 735);
		setLocationRelativeTo(null);		
		
		btnModCliente.addActionListener(new CapturaBtnMP_Tabla(this));
		btnAddCliente.addActionListener(new CapturaBtnMP_Tabla(this));
		btnDelCliente.addActionListener(new CapturaBtnMP_Tabla(this));
		
		btnModAerolinea.addActionListener(new CapturaBtnMP_Tabla(this));
		btnAddAerolinea.addActionListener(new CapturaBtnMP_Tabla(this));
		btnDelAerolinea.addActionListener(new CapturaBtnMP_Tabla(this));
		btnVerVuelos.addActionListener(new CapturaBtnMP_Tabla(this));
		
		btnModVuelo.addActionListener(new CapturaBtnMP_Tabla(this));
		btnAddVuelo.addActionListener(new CapturaBtnMP_Tabla(this));
		btnDelVuelo.addActionListener(new CapturaBtnMP_Tabla(this));
		btnVerClientes.addActionListener(new CapturaBtnMP_Tabla(this));
		
		btnModVenta.addActionListener(new CapturaBtnMP_Tabla(this));
		btnAddVenta.addActionListener(new CapturaBtnMP_Tabla(this));
		btnDelVenta.addActionListener(new CapturaBtnMP_Tabla(this));
								
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},new String[] {} ));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		scrollPane.setRowHeaderView(panel);
		panel.setLayout(new GridLayout(13, 1, 0, 0));
		
		panel_9 = new JPanel();
		panel.add(panel_9);
		
		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnClientes = new JButton("Clientes");
		panel_2.add(btnClientes);
		
		panel_16 = new JPanel();
		panel_2.add(panel_16, BorderLayout.NORTH);
		
		panel_17 = new JPanel();
		panel_2.add(panel_17, BorderLayout.SOUTH);
		
		panel_18 = new JPanel();
		panel_2.add(panel_18, BorderLayout.WEST);
		
		panel_19 = new JPanel();
		panel_2.add(panel_19, BorderLayout.EAST);
		btnClientes.addActionListener(new CapturaBtnMP_Tabla(this));
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnAerolineas = new JButton("  Aerolineas  ");
		panel_3.add(btnAerolineas);
		
		panel_20 = new JPanel();
		panel_3.add(panel_20, BorderLayout.NORTH);
		
		panel_21 = new JPanel();
		panel_3.add(panel_21, BorderLayout.SOUTH);
		
		panel_22 = new JPanel();
		panel_3.add(panel_22, BorderLayout.WEST);
		
		panel_23 = new JPanel();
		panel_3.add(panel_23, BorderLayout.EAST);
		btnAerolineas.addActionListener(new CapturaBtnMP_Tabla(this));
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		btnVuelos = new JButton("Vuelos");
		panel_5.add(btnVuelos);
		
		panel_28 = new JPanel();
		panel_5.add(panel_28, BorderLayout.NORTH);
		
		panel_29 = new JPanel();
		panel_5.add(panel_29, BorderLayout.SOUTH);
		
		panel_30 = new JPanel();
		panel_5.add(panel_30, BorderLayout.WEST);
		
		panel_31 = new JPanel();
		panel_5.add(panel_31, BorderLayout.EAST);
		btnVuelos.addActionListener(new CapturaBtnMP_Tabla(this));
		
		panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		btnVenta = new JButton("Venta");
		panel_7.add(btnVenta);
		
		panel_24 = new JPanel();
		panel_7.add(panel_24, BorderLayout.NORTH);
		
		panel_25 = new JPanel();
		panel_7.add(panel_25, BorderLayout.SOUTH);
		
		panel_26 = new JPanel();
		panel_7.add(panel_26, BorderLayout.WEST);
		
		panel_27 = new JPanel();
		panel_7.add(panel_27, BorderLayout.EAST);
		btnVenta.addActionListener(new CapturaBtnMP_Tabla(this));
		
		panel_40 = new JPanel();
		panel.add(panel_40);
		
		panel_41 = new JPanel();
		panel.add(panel_41);
		
		panel_42 = new JPanel();
		panel.add(panel_42);
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		panel_13 = new JPanel();
		panel.add(panel_13);
		
		panel_14 = new JPanel();
		panel.add(panel_14);
		
		panel_12 = new JPanel();
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblAeropuerto = new JLabel("Aeropuerto");
		lblAeropuerto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAeropuerto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_1.add(lblAeropuerto);
		
		panel_43 = new JPanel();
		panel_1.add(panel_43);
		panel_43.setLayout(new GridLayout(0, 7, 0, 0));
		
		panel_45 = new JPanel();
		panel_43.add(panel_45);
		panel_45.setLayout(new BorderLayout(0, 0));
		
		lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBusqueda.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_45.add(lblBusqueda, BorderLayout.CENTER);
		
		panel_46 = new JPanel();
		panel_43.add(panel_46);
		panel_46.setLayout(new BorderLayout(0, 0));
		
		lblSeleccioneCampo = new JLabel("Seleccione campo");
		lblSeleccioneCampo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_46.add(lblSeleccioneCampo, BorderLayout.CENTER);
		
		panel_47 = new JPanel();
		panel_43.add(panel_47);
		panel_47.setLayout(new BorderLayout(0, 0));
		
		panel_59 = new JPanel();
		panel_47.add(panel_59, BorderLayout.NORTH);
		
		panel_60 = new JPanel();
		panel_47.add(panel_60, BorderLayout.SOUTH);
		
		panel_61 = new JPanel();
		panel_47.add(panel_61, BorderLayout.WEST);
		
		panel_62 = new JPanel();
		panel_47.add(panel_62, BorderLayout.EAST);
		
		comboBox_Busqueda = new JComboBox<String>();
		panel_47.add(comboBox_Busqueda, BorderLayout.CENTER);
		
		panel_48 = new JPanel();
		panel_43.add(panel_48);
		panel_48.setLayout(new BorderLayout(0, 0));
		
		panel_55 = new JPanel();
		panel_48.add(panel_55, BorderLayout.NORTH);
		
		panel_56 = new JPanel();
		panel_48.add(panel_56, BorderLayout.SOUTH);
		
		panel_57 = new JPanel();
		panel_48.add(panel_57, BorderLayout.WEST);
		
		panel_58 = new JPanel();
		panel_48.add(panel_58, BorderLayout.EAST);
		
		textBuscar = new JTextField();
		panel_48.add(textBuscar, BorderLayout.CENTER);
		textBuscar.setColumns(10);
		
		panel_49 = new JPanel();
		panel_43.add(panel_49);
		panel_49.setLayout(new BorderLayout(0, 0));
		
		panel_51 = new JPanel();
		panel_49.add(panel_51, BorderLayout.NORTH);
		
		panel_52 = new JPanel();
		panel_49.add(panel_52, BorderLayout.SOUTH);
		
		panel_53 = new JPanel();
		panel_49.add(panel_53, BorderLayout.WEST);
		
		panel_54 = new JPanel();
		panel_49.add(panel_54, BorderLayout.EAST);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new CapturaBtnMP_Tabla(this));
		panel_49.add(btnBuscar, BorderLayout.CENTER);
		
		panel_50 = new JPanel();
		panel_43.add(panel_50);
		panel_50.setLayout(new BorderLayout(0, 0));
		
		panel_32 = new JPanel();
		panel_50.add(panel_32, BorderLayout.NORTH);
		
		panel_33 = new JPanel();
		panel_50.add(panel_33, BorderLayout.EAST);
		
		panel_34 = new JPanel();
		panel_50.add(panel_34, BorderLayout.WEST);
		
		panel_35 = new JPanel();
		panel_50.add(panel_35, BorderLayout.SOUTH);
		
		panel_Ver = new JPanel();
		panel_50.add(panel_Ver, BorderLayout.CENTER);
		panel_Ver.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_44 = new JPanel();
		panel_43.add(panel_44);
		panel_44.setLayout(new BorderLayout(0, 0));
		panel_Ver.setVisible(true);
		
		panel_Botones = new JPanel();
		contentPane.add(panel_Botones, BorderLayout.SOUTH);
		panel_Botones.setLayout(new GridLayout(0, 7, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_Botones.add(panel_8);
		
		panel_Agregar = new JPanel();
		panel_Agregar.setVisible(true);
		
		panel_10 = new JPanel();
		panel_Botones.add(panel_10);
		panel_Botones.add(panel_Agregar);
		panel_Agregar.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_Botones.add(panel_6);
		
		panel_Modificar = new JPanel();
		panel_Modificar.setVisible(true);
		panel_Botones.add(panel_Modificar);
		panel_Modificar.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_Botones.add(panel_4);
		
		panel_Eliminar = new JPanel();
		panel_Eliminar.setVisible(true);
		panel_Botones.add(panel_Eliminar);
		panel_Eliminar.setLayout(new GridLayout(1, 0, 0, 0));
		panel_Botones.setVisible(true);
		
		this.setVisible(true);
	}

	
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JPanel getPanel_Botones() {
		return panel_Botones;
	}

	public void setPanel_Botones(JPanel panel_Botones) {
		this.panel_Botones = panel_Botones;
	}

	public JPanel getPanel_Modificar() {
		return panel_Modificar;
	}

	public void setPanel_Modificar(JPanel panel_Modificar) {
		this.panel_Modificar = panel_Modificar;
	}

	public JPanel getPanel_Agregar() {
		return panel_Agregar;
	}

	public void setPanel_Agregar(JPanel panel_Agregar) {
		this.panel_Agregar = panel_Agregar;
	}

	public JPanel getPanel_Eliminar() {
		return panel_Eliminar;
	}

	public void setPanel_Eliminar(JPanel panel_Eliminar) {
		this.panel_Eliminar = panel_Eliminar;
	}

	
	public JPanel getPanel_Ver() {
		return panel_Ver;
	}

	public void setPanel_Ver(JPanel panel_Ver) {
		this.panel_Ver = panel_Ver;
	}

	public JButton getBtnClientes() {
		return btnClientes;
	}

	public void setBtnClientes(JButton btnClientes) {
		this.btnClientes = btnClientes;
	}

	public JButton getBtnAerolineas() {
		return btnAerolineas;
	}

	public void setBtnAerolineas(JButton btnAerolineas) {
		this.btnAerolineas = btnAerolineas;
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
	
	public JButton getBtnModCliente() {
		return btnModCliente;
	}

	public void setBtnModCliente(JButton btnModCliente) {
		this.btnModCliente = btnModCliente;
	}

	public JButton getBtnAddCliente() {
		return btnAddCliente;
	}

	public void setBtnAddCliente(JButton btnAddCliente) {
		this.btnAddCliente = btnAddCliente;
	}

	public JButton getBtnDelCliente() {
		return btnDelCliente;
	}

	public void setBtnDelCliente(JButton btnDelCliente) {
		this.btnDelCliente = btnDelCliente;
	}

	public JButton getBtnModAerolinea() {
		return btnModAerolinea;
	}

	public void setBtnModAerolinea(JButton btnModAerolinea) {
		this.btnModAerolinea = btnModAerolinea;
	}

	
	
	public JButton getBtnVerVuelos() {
		return btnVerVuelos;
	}

	public void setBtnVerVuelos(JButton btnVerVuelos) {
		this.btnVerVuelos = btnVerVuelos;
	}

	public JButton getBtnVerClientes() {
		return btnVerClientes;
	}

	public void setBtnVerClientes(JButton btnVerClientes) {
		this.btnVerClientes = btnVerClientes;
	}

	public JButton getBtnAddAerolinea() {
		return btnAddAerolinea;
	}

	public void setBtnAddAerolinea(JButton btnAddAerolinea) {
		this.btnAddAerolinea = btnAddAerolinea;
	}

	public JButton getBtnDelAerolinea() {
		return btnDelAerolinea;
	}

	public void setBtnDelAerolinea(JButton btnDelAerolinea) {
		this.btnDelAerolinea = btnDelAerolinea;
	}

	public JButton getBtnModVuelo() {
		return btnModVuelo;
	}

	public void setBtnModVuelo(JButton btnModVuelo) {
		this.btnModVuelo = btnModVuelo;
	}

	public JButton getBtnAddVuelo() {
		return btnAddVuelo;
	}

	public void setBtnAddVuelo(JButton btnAddVuelo) {
		this.btnAddVuelo = btnAddVuelo;
	}

	public JButton getBtnDelVuelo() {
		return btnDelVuelo;
	}

	public void setBtnDelVuelo(JButton btnDelVuelo) {
		this.btnDelVuelo = btnDelVuelo;
	}

	public JButton getBtnModVenta() {
		return btnModVenta;
	}

	public void setBtnModVenta(JButton btnModVenta) {
		this.btnModVenta = btnModVenta;
	}

	public JButton getBtnAddVenta() {
		return btnAddVenta;
	}

	public void setBtnAddVenta(JButton btnAddVenta) {
		this.btnAddVenta = btnAddVenta;
	}

	public JButton getBtnDelVenta() {
		return btnDelVenta;
	}

	public void setBtnDelVenta(JButton btnDelVenta) {
		this.btnDelVenta = btnDelVenta;
	}
	

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JComboBox<String> getComboBox_Busqueda() {
		return comboBox_Busqueda;
	}

	public void setComboBox_Busqueda(JComboBox<String> comboBox_Busqueda) {
		this.comboBox_Busqueda = comboBox_Busqueda;
	}

	public JTextField getTextBuscar() {
		return textBuscar;
	}

	public void setTextBuscar(JTextField textBuscar) {
		this.textBuscar = textBuscar;
	}

	public int confirmarSalida() {
		if(JOptionPane.showConfirmDialog(null, ("¿Desea realmente salir del sistema?"), "Confirmacion de seleccion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0) {
			return EXIT_ON_CLOSE;
		}
		return JFrame.DO_NOTHING_ON_CLOSE;
		
	}
	
	public void fracasoOperacion(String causa) {
		JOptionPane.showMessageDialog(null, "La operacion no se pudo realizar\n"+causa, "", JOptionPane.WARNING_MESSAGE);
	}
	
	private void close(){
        if (JOptionPane.showConfirmDialog(null, "¿Desea realmente salir del sistema?",
                "Salir del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            System.exit(0);
    }  
	
	public boolean confirmarSeleccion(Cliente cliente,String causa) {
		if(JOptionPane.showConfirmDialog(null, ("Desea seleccionar para su "+causa+" a\n Apellido: "+cliente.getApellido()
		+"\nNombre: "+cliente.getNombre()+"\nDNI: ["+cliente.getDNI()+"]")
				, "Confirmacion de seleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			return true;
		}else {
			return false;
		}
	}

	public boolean confirmarSeleccion(LineaAerea lineaAerea,String causa) {
		if(JOptionPane.showConfirmDialog(null, ("Desea seleccionar para su "+causa+" a\n Aerolinea: "
				+lineaAerea.getNombre()+"\nAlianza: "+lineaAerea.getAlianza()+"\nID: ["+lineaAerea.getId()+"]")
				, "Confirmacion de seleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean confirmarSeleccion(Vuelo vuelo,String causa) {
		if(JOptionPane.showConfirmDialog(null, ("Desea seleccionar para su "+causa+" a\n ID: "+vuelo.getId_vuelo())
				, "Confirmacion de seleccion",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean confirmarSeleccion(Venta venta,String causa) {
		if(JOptionPane.showConfirmDialog(null, ("¿Desea seleccionar para su "+causa+" la siguiente venta?\n ID: ["+venta.getId_venta()+
				"]\nCliente: "+venta.getCliente().getApellido()+", "+venta.getCliente().getNombre()+"\nDNI: ["+venta.getCliente().getDNI()+"]"
				+"\nMonto: ["+venta.getTotalPagar()+"]"), "Confirmacion de seleccion",  JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE)==JOptionPane.OK_OPTION){
			return true;
		}else {
			return false;
		}
	}	
	
	public void cancelaOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha cancelado", "", JOptionPane.WARNING_MESSAGE);
	}
	public void exitoOperacion() {
		JOptionPane.showMessageDialog(null, "La operacion se ha completado con exito", "", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
