package edu.usal.principal;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.Coneccion;
import edu.usal.util.IOGeneralDAO;
import edu.usal.util.PropertiesUtil;

public class AgregarAeropuertosSQL {
	public static void main(String[] args) {
		try{

			List<Aeropuerto> lista = primeraLectura();
			Coneccion con = new Coneccion();
			con.iniciarConeccion();
			PreparedStatement prep;
			for (Aeropuerto linea : lista) {
				String query = ("INSERT INTO Aeropuerto VALUES (?,?,?,?)");
				prep = con.getConeccion().prepareStatement(query);
				prep.setString(1, linea.getIdAeropuerto());
				prep.setString(2, linea.getCiudad());
				prep.setInt(3, linea.getPais().getId());
				prep.setInt(4, linea.getProvincia().getId());
				IOGeneralDAO.pritln(String.valueOf(prep.executeUpdate())+linea.getCiudad());
				prep.close();				
			}
			con.cerrarConeccion();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<Aeropuerto> primeraLectura(){
		ArrayList<Aeropuerto> lista = new ArrayList<Aeropuerto>();
		try {
			File file;
			file= new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getNameAllAeropuertos());
			Scanner scanner= new Scanner(file);
			while (scanner.hasNextLine()){
				String[] straux = scanner.nextLine().split("-");
				Aeropuerto nueva = new Aeropuerto();
				nueva.setCiudad(straux[0]);
				nueva.setIdAeropuerto(straux[1]);
				nueva.setPais(new Pais(Integer.parseInt(straux[2]),null));
				if(nueva.getPais().getId()==9) {
					nueva.setProvincia(new Provincia(Integer.parseInt(straux[3]),null));
				}else {
					nueva.setProvincia(new Provincia (0,null));
				}
				System.out.println(nueva.getIdAeropuerto());
				lista.add(nueva);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
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
			e.printStackTrace();
		}
		return lista;
	}
	
}
