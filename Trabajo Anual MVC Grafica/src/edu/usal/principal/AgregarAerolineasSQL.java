package edu.usal.principal;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public class AgregarAerolineasSQL {
	public static void main(String[] args) {
		cargarLineas();
		
	}
	
	
	


	private static void cargarLineas() {
		try{
			LineaAereaDAO lineaAerea = LineaAereaFactory.getLineaAereaDAO("SQL");
			List<LineaAerea> lista = leer();
			for (LineaAerea linea : lista) {
				lineaAerea.addLineaAerea(linea);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	private static ArrayList<LineaAerea> leer(){
		ArrayList<LineaAerea> lista = new ArrayList<LineaAerea>();
		try {
			File file= new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getNameAllAeroLineas());
			Scanner scanner= new Scanner(file);
			while (scanner.hasNextLine()){
				String[] straux = scanner.nextLine().split("-");
				LineaAerea nueva = new LineaAerea();
				nueva.setAlianza(Integer.parseInt(straux[0]));
				nueva.setNombre(straux[1]);
				nueva.setVuelos(new ArrayList<Vuelo>());
				lista.add(nueva);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
}
