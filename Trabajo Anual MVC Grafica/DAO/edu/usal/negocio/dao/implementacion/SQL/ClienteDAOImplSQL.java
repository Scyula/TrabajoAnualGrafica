package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneral;

public class ClienteDAOImplSQL implements ClienteDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query;
	
	
	@Override
	public boolean addCliente(Cliente cliente)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			con.getConeccion().setAutoCommit(false);
			query = ("INSERT INTO Cliente VALUES (?,?,?,?,?,?);");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,cliente.getDNI());
			prep.setString(2, cliente.getNombre());
			prep.setString(3, cliente.getApellido());
			prep.setString(4, cliente.getCuitcuil());
			prep.setDate(5, convertUtilToSql(cliente.getFechaNac()));
			prep.setString(6, cliente.getEmail());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				if(guardarDireccion(cliente,con) && guardarTelefono(cliente,con) && guardarPasaporte(cliente,con) && guardarPasajero(cliente,con)) {
					con.getConeccion().commit();
					con.cerrarConeccion();
					return true;
				}
			}
		}
		con.getConeccion().rollback();
		prep.close();
		con.cerrarConeccion();
		return false;
	}
	
	@Override
	public boolean updateCliente(Cliente cliente)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = ("INSERT INTO Cliente VALUES (?,?,?,?,?,?) WHERE DNI=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,cliente.getDNI());
			prep.setString(2, cliente.getNombre());
			prep.setString(3, cliente.getApellido());
			prep.setString(4, cliente.getCuitcuil());
			prep.setDate(5, convertUtilToSql(cliente.getFechaNac()));
			prep.setString(6, cliente.getEmail());
			prep.setInt(7, cliente.getDNI());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}else if(r>1) {
				IOGeneral.pritln("CUIDADO, se afectó mas de una sola columna");
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cliente)  throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = ("DELETE FROM Cliente  where DNI=?;");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,cliente.getDNI());
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
	public List<Cliente> getAllCliente()  throws SQLException {
		List <Cliente> lista = new ArrayList<Cliente>();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Cliente";
			prep = con.getConeccion().prepareStatement(query);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				Cliente nuevo = new Cliente(rs.getString(2),rs.getString(3), rs.getInt(1), null, rs.getString(4), stringToFecha(rs.getString(5)), rs.getString(6), null, null, null);
				lista.add(nuevo);
			}
			prep.close();
			con.cerrarConeccion();
			return lista;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}

	@Override
	public Cliente readCliente(int dni) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Cliente WHERE DNI= ?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, dni);
			ResultSet rs = prep.executeQuery();
			rs.next();
			Cliente nuevo = new Cliente(rs.getString(2),rs.getString(3), rs.getInt(1), leerPasaporte(dni), rs.getString(4), stringToFecha(rs.getString(5)), rs.getString(6), leerTelefono(dni), leerPasajero(dni), leerDireccion(dni));
			prep.close();
			con.cerrarConeccion();
			return nuevo;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}
	
	private boolean guardarDireccion(Cliente cliente, Coneccion con) throws SQLException{
		query = ("INSERT INTO Direccion VALUES (?,?,?,?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setInt(2, cliente.getDireccion().getPais().getId());
		if(cliente.getDireccion().getPais().getId()==9) {
			prep.setInt(3, cliente.getDireccion().getProvincia().getId());
		}else {
			prep.setInt(3, -1);
		}
		prep.setString(4, cliente.getDireccion().getCiudad());
		prep.setString(5, cliente.getDireccion().getCodPostal());
		
		prep.setString(6, cliente.getDireccion().getCalle());
		prep.setString(7, cliente.getDireccion().getAltura());
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	
	private boolean guardarTelefono(Cliente cliente, Coneccion con) throws SQLException{
		query = ("INSERT INTO Telefono VALUES (?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getTelefono().getNroPersonal());
		prep.setString(3, cliente.getTelefono().getNroLaboral());
		prep.setString(4, cliente.getTelefono().getNroCelular());
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	private boolean guardarPasaporte(Cliente cliente, Coneccion con) throws SQLException{
		query = ("INSERT INTO Pasaporte VALUES (?,?,?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getPasaporte().getNroPasaporte());
		prep.setString(3, cliente.getPasaporte().getAutoridademision());
		prep.setInt(4, cliente.getPasaporte().getPais().getId());
		prep.setDate(5, convertUtilToSql(cliente.getPasaporte().getEmision()));
		prep.setDate(6, convertUtilToSql(cliente.getPasaporte().getVencimiento()));
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	
	private boolean guardarPasajero(Cliente cliente, Coneccion con) throws SQLException{
		query = ("INSERT INTO PasajeroFrecuente VALUES (?,?,?,?);");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setInt(2, cliente.getPasajeroFrecuente().getAerolinea());
		prep.setString(3, cliente.getPasajeroFrecuente().getNumero());
		prep.setString(4, cliente.getPasajeroFrecuente().getCatergoria());
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	private Telefono leerTelefono(int dni)throws SQLException { // Cliente-Personal-Laboral-Celular
		query = "SELECT * FROM Telefono WHERE DNI= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, dni);
		ResultSet rs = prep.executeQuery();
		rs.next();
		prep.close();
		return new Telefono(rs.getString(2), rs.getString(4), rs.getString(3));
		
	}
	@SuppressWarnings("null")
	private Direccion leerDireccion(int dni)throws SQLException { // cliente-pais-provincia-ciudad-codpostal-calle-altura
		query = "SELECT * FROM Direccion WHERE DNI= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, dni);
		ResultSet rs = prep.executeQuery();
		rs.next();
		prep.close();
		return new Direccion(rs.getString(6), rs.getString(7), rs.getString(4), new Provincia(rs.getInt(3),null), new Pais (rs.getInt(2),null), rs.getString(5));
	}
	private Pasaporte leerPasaporte(int dni)throws SQLException {	// ID_Cliente-NumPasaporte-AutoridadEmision-Pais-FechaEmision-FechaVenc
		query = "SELECT * FROM Pasaporte WHERE DNI= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, dni);
		ResultSet rs = prep.executeQuery();
		rs.next();
		prep.close();
		return new Pasaporte(rs.getString(2), new Pais(rs.getInt(4),null), rs.getString(3), convertFromSQLDateToJAVADate(rs.getDate(5)), convertFromSQLDateToJAVADate(rs.getDate(6)));
	}
	private PasajeroFrecuente leerPasajero(int dni)throws SQLException { //IDCliente-ID_Aerolinea- Numero-Categoria
		query = "SELECT Aerolinea.ID_Alianza, PasajeroFrecuente.ID_Aerolinea, Numero,Categoria  FROM PasajeroFrecuente\r\n" + 
				"INNER JOIN Aerolinea ON PasajeroFrecuente.ID_Aerolinea=Aerolinea.ID_Aerolinea\r\n" + 
				"WHERE ID_Cliente= ?";
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, dni);
		ResultSet rs = prep.executeQuery();
		rs.next();
		prep.close();
		return new PasajeroFrecuente(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
	}
	
	
	
	@SuppressWarnings("deprecation")
	private String fechaToString(Date fecha) {
		return fecha.getYear()+"-"+fecha.getMonth()+"-"+fecha.getDay();
	}
	private Date stringToFecha(String fecha) {
		String[] valores = fecha.split("-");
		@SuppressWarnings("deprecation")
		Date nuevo = new Date(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]));
		return nuevo;
	}
	private java.sql.Date convertUtilToSql(java.util.Date uDate) {
			        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
			        return sDate;
			    }
	private java.util.Date convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {
        java.util.Date javaDate = null;
        if (sqlDate != null) {
            javaDate = new Date(sqlDate.getTime());
        }
        return javaDate;
    }
}
