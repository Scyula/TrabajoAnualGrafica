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
import edu.usal.negocio.dominio.Pais;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneral;

public class ClienteDAOImplSQL implements ClienteDAO {
	//Tabla Cliente => 1 [DNI], 2 [Nombre], 3 [Apellido], 4 [CuitCuil], 5 [FechaNacimiento], 6 [Email]
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query;
	
	
	@Override
	public boolean addCliente(Cliente cliente)  throws SQLException {
		con = new Coneccion();
		con.getConeccion().setAutoCommit(false);
		if(con.iniciarConeccion()) {
			query = ("INSERT INTO Cliente VALUES (?,?,?,?,?,?);");
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,cliente.getDNI());
			prep.setString(2, cliente.getNombre());
			prep.setString(3, cliente.getApellido());
			prep.setString(4, cliente.getCuitcuil());
			prep.setString(5, fechaToString(cliente.getFechaNac()));
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
			prep.setDate(5, (java.sql.Date) cliente.getFechaNac());
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
			Cliente nuevo = new Cliente(rs.getString(2),rs.getString(3), rs.getInt(1), null, rs.getString(4), stringToFecha(rs.getString(5)), rs.getString(6), null, null, null);
			prep.close();
			con.cerrarConeccion();
			return nuevo;
		}
		prep.close();
		con.cerrarConeccion();
		return null;
	}
	
	private boolean guardarDireccion(Cliente cliente, Coneccion con) throws SQLException{
		//1[ID_Cliente] 2[Calle] 3[Altura] 4 [Ciudad] 5[Provincia] 6 [Pais] 7 [CodPostal]
		query = ("INSERT INTO Direccion VALUES (?,?,?,?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getDireccion().getCalle());
		prep.setString(3, cliente.getDireccion().getAltura());
		prep.setString(4, cliente.getDireccion().getCiudad());
		if(cliente.getDireccion().getPais().getId()==9) {
			prep.setString(5, cliente.getDireccion().getProvincia().getNombre());
		}else {
			prep.setString(5, null);
		}
		prep.setString(6, cliente.getDireccion().getPais().getNombre());
		prep.setString(7, cliente.getDireccion().getCodPostal());
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	
	private boolean guardarTelefono(Cliente cliente, Coneccion con) throws SQLException{
		//1[ID_Cliente] 2[Celular] 3[Laboral] 4 [Personal]
		query = ("INSERT INTO Telefono VALUES (?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getTelefono().getNroCelular());
		prep.setString(3, cliente.getTelefono().getNroLaboral());
		prep.setString(4, cliente.getTelefono().getNroPersonal());
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	private boolean guardarPasaporte(Cliente cliente, Coneccion con) throws SQLException{
		//1 nroPasaporte, 2 pais, 3 autoridademision, 4 emision, 5 vencimiento
		query = ("INSERT INTO Pasaporte VALUES (?,?,?,?,?,?)");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getPasaporte().getNroPasaporte());
		prep.setString(3, cliente.getPasaporte().getPais().getNombre());
		prep.setString(4, cliente.getPasaporte().getAutoridademision());
		prep.setString(5, fechaToString(cliente.getPasaporte().getEmision()));
		prep.setString(6, fechaToString(cliente.getPasaporte().getVencimiento()));
		int r= prep.executeUpdate();
		if(r==1) {
			prep.close();
			return true;
		}
		prep.close();
		return false;
	}
	
	private boolean guardarPasajero(Cliente cliente, Coneccion con) throws SQLException{
		//1 alianza, 2 aerolinea, 3 numero, 4 catergoria
		query = ("INSERT INTO PasajeroFrecuente VALUES (?,(Select ID_Aerolinea FROM LineaAerea WHERE Nombre=?),?,?);");
		prep = con.getConeccion().prepareStatement(query);
		prep.setInt(1, cliente.getDNI());
		prep.setString(2, cliente.getPasajeroFrecuente().getAerolinea());
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
}
