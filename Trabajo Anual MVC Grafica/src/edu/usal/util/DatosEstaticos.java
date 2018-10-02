package edu.usal.util;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.implementacion.String.PaisesDAOImplFileString;
import edu.usal.negocio.dao.implementacion.String.ProvinciasDAOImplFileString;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.PaisesDAO;
import edu.usal.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.negocio.dominio.LineaAerea;

public class DatosEstaticos {
	
	private static final String source = "SQL";
	private static ArrayList<LineaAerea> aerolineas= cargarAerolineas();
	private static Hashtable<Integer, String> paises = cargarPaises();
	private static Hashtable<Integer, String> provincias = cargarProvincias();



	public static ArrayList<LineaAerea> getAerolineas() {
		return aerolineas;
	}

	public static void setAerolineas(ArrayList<LineaAerea> aerolineas) {
		DatosEstaticos.aerolineas = aerolineas;
	}

	public static Hashtable<Integer, String> getPaises() {
		return paises;
	}


	public static Hashtable<Integer, String> getProvincias() {
		return provincias;
	}


	public static String getSource() {
		return source;
	}
	
	private static ArrayList<LineaAerea> cargarAerolineas() {
		try {
			LineaAereaDAO lineaAerea = new LineaAereaDAOImplSQL();
			return lineaAerea.primeraLectura();
			
		} catch (SQLException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer las aerolineas de la base de datos<<<<<");
			IOGeneral.pritln(e.getMessage());
		}
		return null;
	}

	private static Hashtable<Integer, String> cargarPaises() {
		try {
			PaisesDAO paisesdao = new PaisesDAOImplFileString();
			return paisesdao.leerPaises();
			
		} catch (IOException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer los paises<<<<<");
			IOGeneral.pritln(e.getMessage());
		}		
		return null;
	}

	private static Hashtable<Integer, String> cargarProvincias() {
		try {
			ProvinciasDAO provinciasdao = new ProvinciasDAOImplFileString();
			return provinciasdao.leerProvincias();
		} catch (IOException e) {
			IOGeneral.pritln(">>>>>Ocurrio un error al leer las provincias<<<<<");
			IOGeneral.pritln(e.getMessage());
		}	
		return null;
	}

	
}
	
