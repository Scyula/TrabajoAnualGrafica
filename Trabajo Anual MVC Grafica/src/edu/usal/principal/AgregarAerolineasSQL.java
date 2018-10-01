package edu.usal.principal;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dao.implementacion.Stream.LineaAereaDAOImplFileStream;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneral;

public class AgregarAerolineasSQL {
	public static void main(String[] args) {
		/*try {

			LineaAereaDAO lineaAerea = new LineaAereaDAOImplFileStream();
			List<LineaAerea> lista = lineaAerea.primeraLectura();
			Coneccion con = new Coneccion();
			con.iniciarConeccion();
			PreparedStatement prep;
			for (LineaAerea linea : lista) {
				String query = ("INSERT INTO Aerolinea VALUES (?,?)");
				prep = con.getConeccion().prepareStatement(query);
				prep.setInt(1, linea.getAlianza());
				prep.setString(2, linea.getNombre());
				IOGeneral.pritln(String.valueOf(prep.executeUpdate())+linea.getNombre());
				prep.close();				
			}
			con.cerrarConeccion();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
