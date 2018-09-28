package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public interface ProvinciasDAO {
		public Hashtable<Integer,String> leerProvincias()throws FileNotFoundException, IOException;;
}
