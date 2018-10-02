package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.Coneccion;

public class LineaAereaDAOImplSQL implements LineaAereaDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query; 
	@Override
	public boolean addLineaAerea(LineaAerea lineaAerea) throws SQLException {
		
		return false;
	}

	@Override
	public boolean updateLineaAerea(LineaAerea lineaAerea) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLineaAerea(LineaAerea lineaAerea) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LineaAerea> getAllLineaAerea() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAllLineaAerea(List<LineaAerea> lineaAerea) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<LineaAerea> primeraLectura() throws SQLException {
		//ArrayList<LineaAerea> lista = new ArrayList<>();
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			/*query = "SELECT *  FROM Aerolinea;";
			stm = con.getConeccion().createStatement();
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				lista.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), null));
			}
			rs.close();
			con.cerrarConeccion();
			LineaAerea[] array = new LineaAerea[lista.size()];
			for (int i=0;i<lista.size();i++) {
				array[i] = lista.get(i);
			}
			return array;*/
			query = "SELECT count(*)  FROM Aerolinea;";
			stm = con.getConeccion().createStatement();
			ResultSet rs = stm.executeQuery(query);
			rs.next();
			ArrayList<LineaAerea> array = new ArrayList<LineaAerea>();
			query = "SELECT *  FROM Aerolinea;";
			stm = con.getConeccion().createStatement();
			rs = stm.executeQuery(query);
			
			while(rs.next()) {
				array.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), null));
				
			}
			rs.close();
			con.cerrarConeccion();
			return array;
			
		}
		return null;
	}

}
