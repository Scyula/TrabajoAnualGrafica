package edu.usal.pantalla.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Hashtable;

import edu.usal.negocio.dao.implementacion.SQL.LineaAereaDAOImplSQL;
import edu.usal.negocio.dao.implementacion.String.PaisesDAOImplFileString;
import edu.usal.negocio.dao.implementacion.String.ProvinciasDAOImplFileString;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.interfaces.PaisesDAO;
import edu.usal.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.pantalla.vista.MenuPrincipalVista;
import edu.usal.util.IOGeneral;

public class MenuPrincipalController{
		MenuPrincipalVista menu;
		GestionClienteController menuCliente;
			
		public MenuPrincipalController() {
			this.menu = new MenuPrincipalVista(this);
		}
		
		public void EjecutarSubmenu(int sb) {
			if(sb==1) {//gestion de cliente
				this.menu.setVisible(false);
				menuCliente = new GestionClienteController(this);
			}else if (sb==2) {//gestion de Lineas Aereas
				
			}else if (sb==3) {//gestion de Vuelos
				
			}else if (sb==4) {//gestion de venta
				
			}else if (sb==5) {//Salir
				
			}
		}

		public GestionClienteController getMenuCliente() {
			return menuCliente;
		}

		public void setMenuCliente(GestionClienteController cliente) {
			this.menuCliente = cliente;
		}
		
		public void guardarDatos() {
			
		}

		public void hacerVisibleMP() {
			this.menu.setVisible(true);
		}

		public Hashtable<Integer, LineaAerea> cargarAerolineas() {
			try {
				LineaAereaDAO lineaAerea = new LineaAereaDAOImplSQL();
				LineaAerea[] linea = lineaAerea.primeraLectura();
				Hashtable<Integer, LineaAerea> lista = new Hashtable<>(linea.length);
				for (LineaAerea lineaAerea2 : linea) {
					lista.put(lineaAerea2.getId(), lineaAerea2);
				}
				return lista;
			} catch (SQLException e) {
				IOGeneral.pritln(">>>>>Ocurrio un error al leer las aerolineas de la base de datos<<<<<");
				IOGeneral.pritln(e.getMessage());
			}
			return null;
		}

		public Hashtable<Integer, String> cargarPaises() {
			try {
				PaisesDAO paisesdao = new PaisesDAOImplFileString();
				return paisesdao.leerPaises();
				
			} catch (IOException e) {
				IOGeneral.pritln(">>>>>Ocurrio un error al leer los paises<<<<<");
				IOGeneral.pritln(e.getMessage());
			}		
			return null;
		}

		public Hashtable<Integer, String> cargarProvincias() {
			try {
				ProvinciasDAO provinciasdao = new ProvinciasDAOImplFileString();
				return provinciasdao.leerProvincias();
			} catch (IOException e) {
				IOGeneral.pritln(">>>>>Ocurrio un error al leer las provincias<<<<<");
				IOGeneral.pritln(e.getMessage());
			}	
			return null;
		}
		
		
}
