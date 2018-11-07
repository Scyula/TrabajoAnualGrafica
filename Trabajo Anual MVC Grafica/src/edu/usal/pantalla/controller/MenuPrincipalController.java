package edu.usal.pantalla.controller;

import javax.swing.JFrame;

import edu.usal.pantalla.vista.MenuPrincipalVista;

public class MenuPrincipalController{
		private MenuPrincipalVista menuPrincipal;
		private Cliente_All_Controller menuModCliente;
		private Cliente_Datos_Controller menuDatosCliente;
		private LineaAerea_Datos_Controller menuDatosLineaAerea;
		private LineaAerea_All_Controller menuModLineaAerea;
		private Venta_Datos_Controller menuDatosVenta;
		private Venta_All_Controller menuAllVenta;
		private Vuelo_Datos_Controller menuDatosVuelo;
		private Vuelo_All_Controller menuModVuelo;
		
		
		public MenuPrincipalController() {
			this.menuPrincipal = new MenuPrincipalVista(this);
		}
		
		public void EjecutarSubmenuCliente(int sb) {
			if(sb==1) {//Nuevo cliente
				this.menuPrincipal.setVisible(false);
				menuDatosCliente = new Cliente_Datos_Controller(this);
			}else if (sb==2) {//Modificar Cliente
				this.menuPrincipal.setVisible(false);
				menuModCliente = new Cliente_All_Controller(this);
			}
		}
		
		public void EjecutarSubmenuAerolinea(int sb) {
			if(sb==1) {//Nuevo Aerolinea
				this.menuPrincipal.setVisible(false);
				menuDatosLineaAerea = new LineaAerea_Datos_Controller(this);
			}else if (sb==2) {//Modificar Aerolinea
				this.menuPrincipal.setVisible(false);
				menuModLineaAerea = new LineaAerea_All_Controller(this);
			}
		}
		public void EjecutarSubmenuVuelo(int sb) {
			if(sb==1) {
				this.menuPrincipal.setVisible(false);
				menuDatosVuelo = new Vuelo_Datos_Controller(this);
			}else if (sb==2) {
				this.menuPrincipal.setVisible(false);
				menuModVuelo = new Vuelo_All_Controller(this);
			}
		}
		public void EjecutarSubmenuVenta(int sb) {
			if(sb==1) {
				this.menuPrincipal.setVisible(false);
				menuDatosVenta = new Venta_Datos_Controller(this);
			}else if (sb==2) {
				this.menuPrincipal.setVisible(false);
				menuAllVenta = new Venta_All_Controller(this);
			}
		}
		
		

		public MenuPrincipalVista getMenuPrincipal() {
			return menuPrincipal;
		}

		public void setMenuPrincipal(MenuPrincipalVista menuPrincipal) {
			this.menuPrincipal = menuPrincipal;
		}

		public Cliente_All_Controller getMenuModCliente() {
			return menuModCliente;
		}

		public void setMenuModCliente(Cliente_All_Controller menuModCliente) {
			this.menuModCliente = menuModCliente;
		}

		public Cliente_Datos_Controller getMenuDatosCliente() {
			return menuDatosCliente;
		}

		public void setMenuDatosCliente(Cliente_Datos_Controller menuDatosCliente) {
			this.menuDatosCliente = menuDatosCliente;
		}

		public LineaAerea_Datos_Controller getMenuDatosLineaAerea() {
			return menuDatosLineaAerea;
		}

		public void setMenuDatosLineaAerea(LineaAerea_Datos_Controller menuDatosLineaAerea) {
			this.menuDatosLineaAerea = menuDatosLineaAerea;
		}

		public LineaAerea_All_Controller getMenuModLineaAerea() {
			return menuModLineaAerea;
		}

		public void setMenuModLineaAerea(LineaAerea_All_Controller menuModLineaAerea) {
			this.menuModLineaAerea = menuModLineaAerea;
		}

		public Venta_Datos_Controller getMenuDatosVenta() {
			return menuDatosVenta;
		}

		public void setMenuDatosVenta(Venta_Datos_Controller menuDatosVenta) {
			this.menuDatosVenta = menuDatosVenta;
		}

		public Venta_All_Controller getMenuAllVenta() {
			return menuAllVenta;
		}

		public void setMenuAllVenta(Venta_All_Controller menuAllVenta) {
			this.menuAllVenta = menuAllVenta;
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
