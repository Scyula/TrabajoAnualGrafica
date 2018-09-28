package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.Conec;

public class ClienteDAOImplSQL implements ClienteDAO {
	Conec con;
	Statement stm;
	String query;
	
	@Override
	public boolean addCliente(Cliente cliente)  throws SQLException {
		con = new Conec();
		if(con.iniciarConeccion()) {
			stm = con.getCon().createStatement();
			query = ("INSERT INTO Cliente values ("+cliente.getDNI()+",'"+cliente.getNombre()+"','"+cliente.getApellido()+"','"+
			cliente.getCuitcuil()+"','"+fechaToString(cliente.getFechaNac())+"','"+cliente.getEmail()+"');");
			int r = stm.executeUpdate(query);
			if(r==1) {
				return true;
			}else if(r>1) {
				return false;
			}else {
				
				return false;
			}
		}
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
	public void readCliente(int dni) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	private String fechaToString(Calendar fecha) {
		return fecha.get(Calendar.YEAR)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.DAY_OF_MONTH);

	}
}
