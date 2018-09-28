package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.LineaAerea ;

public interface LineaAereaDAO {

	public boolean addLineaAerea(LineaAerea lineaAerea) throws FileNotFoundException, IOException;
	public boolean updateLineaAerea(LineaAerea lineaAerea) throws FileNotFoundException, IOException;
	public boolean deleteLineaAerea(LineaAerea  lineaAerea) throws FileNotFoundException, IOException;
	public List<LineaAerea > getAllLineaAerea() throws FileNotFoundException, IOException;
	public void saveAllLineaAerea(List<LineaAerea > lineaAerea) throws FileNotFoundException, IOException;
	
}
