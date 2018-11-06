package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Aeropuerto;

public interface AeropuertoDAO {
//	public boolean addAeropuerto(Aeropuerto aeropuerto) throws SQLException;
//	public boolean updateAeropuerto(Aeropuerto aeropuerto) throws SQLException;
//	public boolean deleteAeropuerto(Aeropuerto aeropuerto) throws SQLException;
	public List<Aeropuerto> getAllAeropuerto() throws SQLException;
	public Aeropuerto readAeropuerto(String id) throws SQLException;
}
