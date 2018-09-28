package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Aeropuerto;

public interface AeropuertoDAO {
	public boolean addAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException;
	public boolean updateAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException;
	public boolean deleteAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException;
	public List<Aeropuerto> getAllAeropuerto() throws FileNotFoundException, IOException;
	public void saveAllAeropuerto(List<Aeropuerto> list) throws FileNotFoundException, IOException;
}
