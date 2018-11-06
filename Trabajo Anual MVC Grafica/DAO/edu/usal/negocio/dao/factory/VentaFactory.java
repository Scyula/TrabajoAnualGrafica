package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.SQL.VentaDAOImplSQL;
import edu.usal.negocio.dao.interfaces.VentaDAO;

public class VentaFactory {
	public static VentaDAO getVentaDAO(String source){
		return new VentaDAOImplSQL();
}
}
