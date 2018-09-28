package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.SQL.ClienteDAOImplSQL;
//import edu.usal.negocio.dao.implementacion.Stream.ClienteDAOImplFileStream;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ClienteFactory {
	public static ClienteDAO getClienteDAO(String source){
		if(source.equalsIgnoreCase("stream")) {
			//return new ClienteDAOImplFileStream();	
		}else if(source.equalsIgnoreCase("SQL")) {
			return new ClienteDAOImplSQL();
		}
		return null;
	}
}
