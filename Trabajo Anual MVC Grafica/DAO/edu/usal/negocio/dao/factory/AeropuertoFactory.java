package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.SQL.AeropuertoDAOImplSQL;
import edu.usal.negocio.dao.interfaces.AeropuertoDAO;

public class AeropuertoFactory {
	public static AeropuertoDAO getAeropuertoDAO(String source){
		if(source.equals("SQL")) {
			return new AeropuertoDAOImplSQL();	
		}
		return null;
}
}
