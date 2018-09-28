package edu.usal.pantalla.controller;


import edu.usal.pantalla.vista.MenuPrincipalVista;

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
		
		
}
