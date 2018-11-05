package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Vuelo;

public interface VueloDAO {

	public boolean addVuelo(Vuelo vuelo) throws SQLException;
	public boolean updateVuelo(Vuelo vuelo) throws SQLException;
	public boolean deleteVuelo(Vuelo  vuelo) throws SQLException;
	public List<Vuelo > getAllVuelo() throws SQLException;
	public Vuelo readVuelo(String id) throws SQLException;
}
