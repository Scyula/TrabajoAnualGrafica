package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.Stream.LineaAereaDAOImplFileStream;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;

public class LineaAereaFactory {
	public static LineaAereaDAO getLineaAereaDAO(){
		return new LineaAereaDAOImplFileStream();
}
}
