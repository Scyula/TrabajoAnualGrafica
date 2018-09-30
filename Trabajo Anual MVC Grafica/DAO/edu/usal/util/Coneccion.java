package edu.usal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Coneccion {
	private Connection coneccion;
	
	public Coneccion() {
		coneccion=null;
	}
	
	public boolean iniciarConeccion() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.coneccion = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:49170;databaseName=TrabajoAnual", "sa", "agus123");	
			return true;
		} catch (ClassNotFoundException e) {
			IOGeneral.pritln("Error al cargar driver SQL.");
			return false;
		}		
	}
	
	public boolean cerrarConeccion()  throws SQLException {
		if(!this.coneccion.isClosed()) {
			this.coneccion.close();
			return true;
		}else {
			IOGeneral.pritln("No hay coneccion activa, verificar codigo");
			return false;
		}
	}

	public Connection getConeccion() {
		return coneccion;
	}

	public void setConeccion(Connection con) {
		this.coneccion = con;
	}
	
	
	
}
