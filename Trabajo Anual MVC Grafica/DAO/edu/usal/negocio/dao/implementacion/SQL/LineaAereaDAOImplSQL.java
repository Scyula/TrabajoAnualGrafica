package edu.usal.negocio.dao.implementacion.SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.usal.negocio.dao.factory.VueloFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneral;

public class LineaAereaDAOImplSQL implements LineaAereaDAO {
	Coneccion con;
	Statement stm;
	PreparedStatement prep;
	String query; 
	
	@Override
	public boolean addLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "INSERT INTO Aerolinea VALUES (?,?,?)";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getAlianza());
			prep.setString(2, lineaAerea.getNombre());
			prep.setString(3, AsignarREF(lineaAerea.getNombre(), con));
			int r = prep.executeUpdate();
			if(r==1) {
				
				
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	@Override
	public boolean updateLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "UPDATE Aerolinea SET ID_Alianza= ? ,Nombre= ? WHERE ID_Aerolinea= ? ;";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getAlianza());
			prep.setString(2, lineaAerea.getNombre());
			prep.setInt(3, lineaAerea.getId());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	@Override
	public boolean deleteLineaAerea(LineaAerea lineaAerea) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "DELETE FROM Aerolinea WHERE ID_Aerolinea= ? ;";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, lineaAerea.getId());
			int r = prep.executeUpdate();
			if(r==1) {
				prep.close();
				con.cerrarConeccion();
				return true;
			}
		}
		prep.close();
		con.cerrarConeccion();
		return false;
	}

	
	public ArrayList<LineaAerea> getAllLineaAerea() throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			ArrayList<LineaAerea> array = new ArrayList<LineaAerea>();
			query = "SELECT *  FROM Aerolinea;";
			stm = con.getConeccion().createStatement();
			ResultSet rs = stm.executeQuery(query);
			
			while(rs.next()) {
				//array.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), leerVuelos(rs.getInt(1))));
				array.add(new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), null));
			}
			rs.close();
			con.cerrarConeccion();
			return array;
			
		}
		return null;
	}

	private ArrayList<Vuelo> leerVuelos(int id) throws SQLException {
		ArrayList<Vuelo> lista = new ArrayList<Vuelo>();
		VueloDAO vuelos = VueloFactory.getVueloDAO("SQL");
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT v.ID_Vuelo FROM Aerolinea a INNER JOIN Vuelo v ON v.ID_Aerolinea=a.ID_Aerolinea WHERE a.ID_Aerolinea=?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1,id);
			ResultSet rs = prep.executeQuery();
			while(rs.next()) {
				lista.add(vuelos.readVuelo(rs.getString(1)));
				}
			prep.close();
			return lista;
		}
		prep.close();
		return lista;
	}

	
	public LineaAerea readLineaAerea(int id) throws SQLException {
		con = new Coneccion();
		if(con.iniciarConeccion()) {
			query = "SELECT * FROM Aerolinea WHERE ID_Aerolinea= ?";
			prep = con.getConeccion().prepareStatement(query);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			rs.next();
			LineaAerea leer=  new LineaAerea(rs.getInt(1),rs.getString(3), rs.getInt(2), leerVuelos(rs.getInt(1)));
			rs.close();
			prep.close();
			con.cerrarConeccion();
			return leer;
		}
		return null;		
	}

	private String AsignarREF( String nom, Coneccion con ) throws SQLException {
		ArrayList<String> ref = leerRefExistentes(con);
		String[] nombre = nom.split(" ");
		char[] primero = nombre[0].toCharArray();
		String aux = "";
		if(nombre.length>1) {
			boolean queda = false;
			while(!queda) {
				char[] segundo = nombre[1].toCharArray();
				for(int i=0;i<primero.length;i++) {
					for(int j=0;j<segundo.length;j++) {
						aux= String.valueOf(Character.toString(primero[i]).toUpperCase()+Character.toString(segundo[j]).toUpperCase());
						queda = comprobar(aux,ref);
						if(queda==true) {
							break;
						}
					}
					if(queda==true) {
						break;
					}
				}
			}
		}else {
			boolean queda = false;
			while(!queda) {
				for(int i=0;i<primero.length-1;i++) {
					for(int j=1;j<primero.length-1;j++) {
						aux= String.valueOf(Character.toString(primero[i]).toUpperCase()+Character.toString(primero[j]).toUpperCase());
						queda = comprobar(aux,ref);	
						if(queda) {
							break;
						}
					}	
					if(queda) {
						break;
					}
				}
			}
		}
		IOGeneral.pritln(aux);
		return aux;
	}

	private boolean comprobar(String aux, ArrayList<String> ref) {
		for (String string : ref) {
			if(string.equalsIgnoreCase(aux)) {
				return false;
			}
		}
		return true;
	}

	private ArrayList<String> leerRefExistentes(Coneccion con) throws SQLException {
		ArrayList<String> lista = new ArrayList<String>();
		String query = ("SELECT REF FROM Aerolinea");
		PreparedStatement prep = con.getConeccion().prepareStatement(query);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			lista.add(rs.getString(1));
		}
		prep.close();
		return lista;
	}

}
