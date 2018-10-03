package edu.usal.negocio.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dominio.LineaAerea ;

public interface LineaAereaDAO {

	public boolean addLineaAerea(LineaAerea lineaAerea) throws SQLException;
	public boolean updateLineaAerea(LineaAerea lineaAerea) throws SQLException;
	public boolean deleteLineaAerea(LineaAerea  lineaAerea) throws SQLException;
	public ArrayList<LineaAerea > getAllLineaAerea() throws SQLException;
	
}
