package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.SQL.VueloDAOImplSQL;
import edu.usal.negocio.dao.interfaces.VueloDAO;

public class VueloFactory {
	public static VueloDAO getVueloDAO(String source){
			return new VueloDAOImplSQL();
	}
}
