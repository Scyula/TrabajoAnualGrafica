package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Venta;

public interface VentaDAO {

	public boolean addVenta(Venta venta) throws SQLException;
	public boolean updateVenta(Venta venta) throws SQLException;
	public boolean deleteVentas(Venta  venta) throws SQLException;
	public List<Venta> getAllVenta() throws SQLException;
	public Venta readVenta(int id) throws SQLException;
	
	
}
