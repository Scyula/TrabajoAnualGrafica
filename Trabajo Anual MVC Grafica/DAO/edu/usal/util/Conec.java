package edu.usal.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conec {
	private Connection con;
	
	public Conec() {
		con=null;
	}
	
	public boolean iniciarConeccion() throws SQLException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			this.con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:49170;databaseName=TrabajoAnual", "sa", "agus123");	
			return true;
		} catch (ClassNotFoundException e) {
			IOGeneral.pritln("Error al cargar driver SQL.");
			return false;
		}		
	}
	
	public boolean cerrarConeccion()  throws SQLException {
		if(!this.con.isClosed()) {
			this.con.close();
			return true;
		}else {
			IOGeneral.pritln("No hay coneccion activa, verificar codigo");
			return false;
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	
}
