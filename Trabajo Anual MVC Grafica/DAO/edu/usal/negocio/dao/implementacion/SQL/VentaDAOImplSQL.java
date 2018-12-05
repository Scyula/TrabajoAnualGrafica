package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dao.factory.ClienteFactory;
import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;

public class VentaDAOImplSQL implements VentaDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query;
	
	
	public boolean addVenta(Venta venta)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			con.getConeccion().setAutoCommit(false);
			query = ("INSERT INTO Ventas VALUES (?,?,?,?,?,?,?)");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,venta.getCliente().getDNI());
			prep.setInt(2, venta.getLineaAerea().getId());
			prep.setString(3, venta.getVuelo().getId_vuelo());
			prep.setTimestamp(4, dateToTimestamp(venta.getFechaHoraVenta()));
			prep.setString(5, venta.getFormaPago());
			prep.setInt(6, venta.getCuotas());
			prep.setDouble(7, venta.getTotalPagar());
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
	
	
	public boolean updateVenta(Venta venta)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			con.getConeccion().setAutoCommit(false);
			query = ("UPDATE Ventas SET ID_Cliente=?,ID_Aerolinea=?,ID_Vuelo=?,FechaHoraVenta=?,MedioPago=?,Cuotas=?,Total=? WHERE ID_Venta=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,venta.getCliente().getDNI());
			prep.setInt(2, venta.getLineaAerea().getId());
			prep.setString(3, venta.getVuelo().getId_vuelo());
			prep.setTimestamp(4, dateToTimestamp(venta.getFechaHoraVenta()));
			prep.setString(5, venta.getFormaPago());
			prep.setInt(6, venta.getCuotas());
			prep.setDouble(7, venta.getTotalPagar());
			prep.setInt(8, venta.getId_venta());
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

	
	public boolean deleteVentas(Venta venta)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = ("DELETE FROM Ventas WHERE ID_Venta=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,venta.getId_venta());
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

	
	public List<Venta> getAllVenta()  throws SQLException {
		List <Venta> lista = new ArrayList<Venta>();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Ventas";
			prep = con.getConeccion().prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(new Venta(rs.getInt(1), leerCliente(rs.getInt(2)), leerVuelo(rs.getString(4)), leerAerolinea(rs.getInt(3)), 
						timestampToDate(rs.getTimestamp(5)), rs.getString(6), rs.getInt(7), rs.getDouble(8)));
				}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}

	
	private Vuelo leerVuelo(String string) throws SQLException {
		VueloDAO vuelo = VueloFactory.getVueloDAO("SQL");
		Vuelo leer = vuelo.readVuelo(string);
		return leer;
	}


	private Cliente leerCliente(int i) throws SQLException {
		ClienteDAO clientes = ClienteFactory.getClienteDAO("SQL");
		Cliente leer = clientes.readCliente(i);
		return leer;
	}


	private LineaAerea leerAerolinea(int id)throws SQLException { 
		LineaAereaDAO lineaaerea = LineaAereaFactory.getLineaAereaDAO("SQL");
		LineaAerea leer = lineaaerea.readLineaAerea(id);
		return leer;
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

	public Venta readVenta(int id) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Ventas WHERE ID_Venta=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(0, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			Venta leer = new Venta(rs.getInt(1), leerCliente(rs.getInt(2)), leerVuelo(rs.getString(4)), leerAerolinea(rs.getInt(3)), 
					timestampToDate(rs.getTimestamp(5)), rs.getString(6), rs.getInt(7), rs.getDouble(8));
			
			prep.close();
			con.cerrarConeccion();
			return leer;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}

}
