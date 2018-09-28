package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.String.ProvinciasDAOImplFileString;
import edu.usal.negocio.dao.interfaces.ProvinciasDAO;

public class ProvinciasFactory {
	public static ProvinciasDAO getProvinciasDAO(){
		return new ProvinciasDAOImplFileString();
}
}
