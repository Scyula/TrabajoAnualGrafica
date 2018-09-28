package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Venta;

public interface VentaDAO {

	public boolean addVenta(Venta venta) throws FileNotFoundException, IOException;
	public boolean updateVenta(Venta venta) throws FileNotFoundException, IOException;
	public boolean deleteVentas(Venta  venta) throws FileNotFoundException, IOException;
	public List<Venta> getAllVenta() throws FileNotFoundException, IOException;
	public void saveAllVenta(List<Venta> list) throws FileNotFoundException, IOException;
	
}
