package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public interface AlianzasDAO {
	public Hashtable<Integer,String> leerAlianzas()throws FileNotFoundException, IOException;

}
