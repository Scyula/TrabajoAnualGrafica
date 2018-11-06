package edu.usal.principal;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.factory.LineaAereaFactory;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneral;
import edu.usal.util.PropertiesUtil;

public class AgregarAerolineasSQL {
	public static void main(String[] args) {
		cargarLineas();
		
		AsignarREF();
		
	}
	
	
	
	private static void AsignarREF() {
		try {
		LineaAereaDAO lineaAerea = new LineaAereaDAOImplSQL();
		List<LineaAerea> lista = lineaAerea.getAllLineaAerea();
		Coneccion con = new Coneccion();
		con.iniciarConeccion();
		PreparedStatement prep;
		ArrayList<String> ref = new ArrayList<String>();
		for (LineaAerea linea : lista) {
			String[] nombre = linea.getNombre().split(" ");
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
			ref.add(aux);
			System.out.println(aux);
			String query = ("UPDATE Aerolinea SET REF = ? WHERE ID_Aerolinea=?");
			prep = con.getConeccion().prepareStatement(query);
			prep.setString(1, aux);
			prep.setInt(2, linea.getId());
			IOGeneral.pritln(String.valueOf(prep.executeUpdate())+"->"+linea.getId());
			prep.close();	
			
						
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	private static boolean comprobar(String aux, ArrayList<String> ref) {
		for (String string : ref) {
			if(string.equalsIgnoreCase(aux)) {
				return false;
			}
		}
		return true;
	}



	private static void cargarLineas() {
		try{
			LineaAereaDAO lineaAerea = LineaAereaFactory.getLineaAereaDAO("SQL");
			List<LineaAerea> lista = leer();
//			Coneccion con = new Coneccion();
//			con.iniciarConeccion();
//			PreparedStatement prep;
			for (LineaAerea linea : lista) {
				lineaAerea.addLineaAerea(linea);
//				String query = ("INSERT INTO Aerolinea VALUES (?,?,null)");
//				prep = con.getConeccion().prepareStatement(query);
//				prep.setInt(1, linea.getAlianza());
//				prep.setString(2, linea.getNombre());
//				IOGeneral.pritln(String.valueOf(prep.executeUpdate())+linea.getNombre());
//				prep.close();				
			}
//			con.cerrarConeccion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
