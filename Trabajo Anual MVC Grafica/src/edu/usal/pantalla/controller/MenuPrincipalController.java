package edu.usal.pantalla.controller;

import javax.swing.JFrame;

import edu.usal.pantalla.vista.MenuPrincipalVista;

public class MenuPrincipalController{
		private MenuPrincipalVista menuPrincipal;
		private Cliente_ModDel_Controller menuMod;
		private Cliente_Datos_Controller menuDatos;
			
		public MenuPrincipalController() {
			this.menuPrincipal = new MenuPrincipalVista(this);
		}
		
		public void EjecutarSubmenuCliente(int sb) {
			if(sb==1) {//Nuevo cliente
				this.menuPrincipal.setVisible(false);
				menuDatos = new Cliente_Datos_Controller(this);
			}else if (sb==2) {//Modificar Cliente
				this.menuPrincipal.setVisible(false);
				menuMod = new Cliente_ModDel_Controller(this);
			}
		}

		public MenuPrincipalVista getMenuPrincipal() {
			return menuPrincipal;
		}

		public Cliente_ModDel_Controller getMenuMod() {
			return menuMod;
		}

		public Cliente_Datos_Controller getMenuDatos() {
			return menuDatos;
		}

		public void hacerVisibleMP() {
			this.menuPrincipal.setVisible(true);
		}

		public void Salir() {
			if(menuPrincipal.confirmarSalida()==JFrame.EXIT_ON_CLOSE) {
				System.exit(0);
			}
			
		}		
		
}
