package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;

public class LineaAereaDAOImplSQL implements LineaAereaDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query; 
	
	@Override
	public boolean addLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "INSERT INTO Aerolinea VALUES (?,?,null)";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getAlianza());
			prep.setString(2, lineaAerea.getNombre());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	@Override
	public boolean updateLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "UPDATE Aerolinea SET ID_Alianza= ? ,Nombre= ? WHERE ID_Aerolinea= ? ;";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getAlianza());
			prep.setString(2, lineaAerea.getNombre());
			prep.setInt(3, lineaAerea.getId());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	@Override
	public boolean deleteLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "DELETE FROM Aerolinea WHERE ID_Aerolinea= ? ;";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getId());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	
	public ArrayList<LineaAerea> getAllLineaAerea() throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			ArrayList<LineaAerea> array = new ArrayList<LineaAerea>();
			query = "SELECT *  FROM Aerolinea;";
			stm = con.getConeccion().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				//array.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), leerVuelos(rs.getInt(1))));
				array.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), null));
			}
			rs.close();
			con.cerrarConeccion();
			return array;
			
		}
		return null;
	}

	private ArrayList<Vuelo> leerVuelos(int id) throws SQLException {
		ArrayList<Vuelo> lista = new ArrayList<Vuelo>();
		VueloDAO vuelos = VueloFactory.getVueloDAO("SQL");
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT Vuelo.ID_Vuelo FROM Aerolinea INNER JOIN Vuelo ON Vuelo.ID_Aerolinea=Aerolinea.ID_Aerolinea WHERE ID_Aerolinea=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,id);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(vuelos.readVuelo(rs.getString(1)));
				}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return lista;
	}

	
	public LineaAerea readLineaAerea(int id) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Aerolinea WHERE ID_Aerolinea= ?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			LineaAerea leer=  new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), leerVuelos(rs.getInt(1)));
			rs.close();
			prep.close();
			con.cerrarConeccion();
			return leer;
		}
		return null;		
	}


}
