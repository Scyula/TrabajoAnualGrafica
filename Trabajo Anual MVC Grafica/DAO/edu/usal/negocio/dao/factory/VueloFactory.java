package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.Stream.VueloDAOImplFileStream;
import edu.usal.negocio.dao.interfaces.VueloDAO;

public class VueloFactory {
	public static VueloDAO getVueloDAO(){
			return new VueloDAOImplFileStream();
	}
}
