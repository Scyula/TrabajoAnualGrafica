package edu.usal.util;

import java.util.Properties;


import java.io.*;

public class PropertiesUtil {
	private static Properties config = cargarProperties();
	
	private static Properties cargarProperties() {
			config = new Properties();
			try {
				config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
				return config;
			} catch (IOException e) {
				IOGeneral.pritln("Error al leer el archivo properties\nMensaje: "+e.getMessage());
			}
			return null;
	}
	
	public static String getPathCliente(){
			return config.getProperty("pathCliente");
	}
	
	public static String getNameAlianzas(){
			return config.getProperty("nameFileAlianzas");
	}
	public static String getNamePaises(){
			return config.getProperty("nameFilePaises");
	}
	public static String getNameProvincias(){
			return config.getProperty("nameFileProvincias");
	}
	
	public static String getNameAllAeroLineas(){
			return config.getProperty("nameFileAllAeroLineas");
	}
	public static String getNameAllAeropuertos(){
			return config.getProperty("nameFileAllAeropuertos");
	}
	public static String getNamePathAeropuerto() {
			return config.getProperty("nameFileAeropuerto");
	}

	public static String getPathAeropuerto() {
			return config.getProperty("pathAeropuerto");
	}

	public static String getPathTxt() {
			return config.getProperty("pathTxt");
	}
	public static String getDriver() {
			return config.getProperty("Driver");
	}
	public static String getConSQL() {
		return ("jdbc:sqlserver://"+PropertiesUtil.getIP()+":"+
		PropertiesUtil.getHost()+";databaseName="+PropertiesUtil.getDBName());
	}
	public static String getDBName() {
				return config.getProperty("DBName");
	}
	
	public static String getIP() {
		return config.getProperty("IP");
	}
	public static String getHost() {
		return config.getProperty("Host");
	}
	public static String getUser() {
		return config.getProperty("User");
	}
	public static String getPassword() {
		return config.getProperty("Password");
	}
	
}
