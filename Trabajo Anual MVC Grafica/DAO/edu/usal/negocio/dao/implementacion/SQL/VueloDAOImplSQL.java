package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;
import edu.usal.util.DatosEstaticos;

public class VueloDAOImplSQL implements VueloDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query;
	
	
	public boolean addVuelo(Vuelo vuelo)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			CallableStatement cal;
			con.getConeccion().setAutoCommit(false);
			query = ("EXEC Alta_Vuelo ?,?,?,?,?,?,?,?");
			cal = con.getConeccion().prepareCall(query);
			cal.setInt(1,vuelo.getAerolinea().getId());
			cal.setInt(2, vuelo.getCantAsientos());
			cal.setInt(3, vuelo.getAsientosDisponibles());
			cal.setString(4, vuelo.getAeroSalida().getIdAeropuerto());
			cal.setString(5, vuelo.getAeroLlegada().getIdAeropuerto());
			cal.setTimestamp(6, dateToTimestamp(vuelo.getFechaHoraSalida()));
			cal.setTimestamp(7, dateToTimestamp(vuelo.getFechaHoraLlegada()));
			cal.setString(8, vuelo.getTiempoVuelo());
			int r = prep.executeUpdate();
			if(r==1) {
				con.getConeccion().commit();
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		con.getConeccion().rollback();
		prep.close();
		con.cerrarConeccion();
		return false;
	}
	
	
	public boolean updateVuelo(Vuelo vuelo)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			con.getConeccion().setAutoCommit(false);
			query = ("UPDATE Vuelo SET ID_Aerolinea=?,CantAsientos=?,AsientosDisp=?,ID_AeropuertoSalida=?,ID_AeropuertoLlegada=?,FechaHoraSalida=?,FechaHoraLlegada=?,TiempoVuelo=? WHERE ID_Vuelo=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,vuelo.getAerolinea().getId());
			prep.setInt(2, vuelo.getCantAsientos());
			prep.setInt(3, vuelo.getAsientosDisponibles());
			prep.setString(4, vuelo.getAeroSalida().getIdAeropuerto());
			prep.setString(5, vuelo.getAeroLlegada().getIdAeropuerto());
			prep.setTimestamp(6, dateToTimestamp(vuelo.getFechaHoraSalida()));
			prep.setTimestamp(7, dateToTimestamp(vuelo.getFechaHoraLlegada()));
			prep.setString(8, vuelo.getTiempoVuelo());
			prep.setString(9, vuelo.getId_vuelo());
			int r = prep.executeUpdate();
			if(r==1) {
				con.getConeccion().commit();
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		con.getConeccion().rollback();
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	
	public boolean deleteVuelo(Vuelo vuelo)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = ("DELETE FROM Vuelo WHERE ID_Vuelo=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setString(1,vuelo.getId_vuelo());
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

	
	public List<Vuelo> getAllVuelo()  throws SQLException {
		List <Vuelo> lista = new ArrayList<Vuelo>();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Vuelo";
			prep = con.getConeccion().prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(new Vuelo(rs.getString(1), leerAerolinea(rs.getInt(2)), rs.getInt(3), rs.getInt(4), leerAeropuerto(rs.getString(5)), leerAeropuerto(rs.getString(6)),
						timestampToDate(rs.getTimestamp(7)), timestampToDate(rs.getTimestamp(8)), rs.getString(9), leerClientes(rs.getString(1))));
				}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}

	


	private List<Cliente> leerClientes(String string) throws SQLException {
		List<Cliente> lista = new ArrayList<Cliente>();
		ClienteDAO clientes = new ClienteDAOImplSQL();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT c.DNI FROM Ventas v INNER JOIN Cliente c ON v.ID_Cliente=c.DNI WHERE ID_Vuelo=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setString(1,string);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(clientes.readCliente(rs.getInt(1)));
				}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return lista;
	}


	public Vuelo readVuelo(String id) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Vuelo WHERE ID_Vuelo=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setString(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			Vuelo leer = new Vuelo(rs.getString(1), leerAerolinea(rs.getInt(2)), rs.getInt(3), rs.getInt(4), leerAeropuerto(rs.getString(5)), leerAeropuerto(rs.getString(6)),
						timestampToDate(rs.getTimestamp(7)), timestampToDate(rs.getTimestamp(8)), rs.getString(9), leerClientes(rs.getString(1)));
			prep.close();
			con.cerrarConeccion();
			return leer;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}	
	
	private LineaAerea leerAerolinea(int id)throws SQLException { 
		query = "SELECT * FROM Aerolinea WHERE ID_Aerolinea= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		rs.next();
		return new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), null);
	}

	private Aeropuerto leerAeropuerto(String string) throws SQLException {
		query = "SELECT * FROM Aeropuerto WHERE ID_Aeropuerto= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setString(1, string);
		ResultSet rs = prep.executeQuery();
		rs.next();
		return new Aeropuerto(rs.getString(1),rs.getString(2), new Provincia(rs.getInt(4),DatosEstaticos.getProvincias().get(rs.getInt(4))),
				new Pais(rs.getInt(3),DatosEstaticos.getPaises().get(rs.getInt(3))));
	}	
	
	public Timestamp dateToTimestamp(java.util.Date date){
		if(date!=null) {
			return new java.sql.Timestamp(date.getTime());
		}
		  return null;
		}

	private java.util.Date timestampToDate(java.sql.Timestamp sqlDate) {
        if (sqlDate != null) {
            return new Date(sqlDate.getTime());
        }
        return null;
    }

}
