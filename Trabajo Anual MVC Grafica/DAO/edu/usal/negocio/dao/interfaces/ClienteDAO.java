package edu.usal.negocio.dao.interfaces;


import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Cliente;

public interface ClienteDAO {
	public boolean addCliente(Cliente cliente) throws SQLException;
	public boolean updateCliente(Cliente cliente) throws SQLException;
	public boolean deleteCliente(Cliente cliente) throws SQLException;
	public List<Cliente> getAllCliente() throws SQLException;
	public Cliente readCliente(int dni) throws SQLException;
	
}
