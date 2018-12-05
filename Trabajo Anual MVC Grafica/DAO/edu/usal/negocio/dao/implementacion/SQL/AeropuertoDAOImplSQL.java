package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.util.Coneccion;
import edu.usal.util.DatosEstaticos;

public class AeropuertoDAOImplSQL implements AeropuertoDAO {
	Coneccion con;
	PreparedStatement prep;
	String query;
	
	public List<Aeropuerto> getAllAeropuerto() throws SQLException {
		List <Aeropuerto> lista = new ArrayList<Aeropuerto>();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Aeropuerto ORDER BY Ciudad";
			prep = con.getConeccion().prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(new Aeropuerto(rs.getString(1), rs.getString(2),
						new Provincia(rs.getInt(4), DatosEstaticos.getProvincias().get(rs.getInt(4))),
						new Pais(rs.getInt(3),DatosEstaticos.getPaises().get(rs.getInt(3)))));
				}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return lista;
	}


	public Aeropuerto readAeropuerto(String id) throws SQLException {
		Aeropuerto leer = new Aeropuerto();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Aeropuerto WHERE ID_Aeropuerto=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setString(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			leer =  new Aeropuerto(rs.getString(1), rs.getString(2),
					new Provincia(rs.getInt(4), DatosEstaticos.getProvincias().get(rs.getInt(4))),
					new Pais(rs.getInt(3),DatosEstaticos.getPaises().get(rs.getInt(3))));
			
			prep.close();
			con.cerrarConeccion();
			return leer;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}

}
