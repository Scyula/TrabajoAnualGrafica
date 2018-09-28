package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Vuelo;

public interface VueloDAO {

	public boolean addVuelo(Vuelo vuelo) throws FileNotFoundException, IOException;
	public boolean updateVuelo(Vuelo vuelo) throws FileNotFoundException, IOException;
	public boolean deleteVuelo(Vuelo  vuelo) throws FileNotFoundException, IOException;
	public List<Vuelo > getAllVuelo() throws FileNotFoundException, IOException;
	public void saveAllVuelo(List<Vuelo > list) throws FileNotFoundException, IOException;
}
