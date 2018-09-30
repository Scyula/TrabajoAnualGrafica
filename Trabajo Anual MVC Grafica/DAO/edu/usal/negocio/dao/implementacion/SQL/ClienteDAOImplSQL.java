package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
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
	public boolean updateCliente(Cliente cliente)  throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cliente)  throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cliente> getAllCliente()  throws SQLException {
		// TODO Auto-generated method stub
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
