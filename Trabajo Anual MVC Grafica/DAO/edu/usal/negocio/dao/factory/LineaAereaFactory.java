package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;

public class LineaAereaFactory {
	public static LineaAereaDAO getLineaAereaDAO(String source){
		if(source.equalsIgnoreCase("SQL")){
			return new LineaAereaDAOImplSQL();
		}
		return null;
}
}
