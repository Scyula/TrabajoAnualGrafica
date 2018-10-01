package edu.usal.principal;

import java.util.Hashtable;

import javax.swing.SwingUtilities;

import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.pantalla.controller.MenuPrincipalController;

public class Principal {
	public static final String source = "SQL";
	public static Hashtable<Integer, LineaAerea> aerolineas;
	public static Hashtable<Integer, String> paises;
	public static Hashtable<Integer, String> provincias;
	
	public static void main(String[] args) {
			MenuPrincipalController menu = new MenuPrincipalController();	
			aerolineas = menu.cargarAerolineas();
			paises = menu.cargarPaises();
			provincias = menu.cargarProvincias();
		}
}
