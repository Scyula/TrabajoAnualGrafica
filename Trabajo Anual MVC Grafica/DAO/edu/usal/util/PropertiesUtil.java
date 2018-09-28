package edu.usal.util;

import java.util.Properties;
import java.io.*;

public class PropertiesUtil {
	private static Properties config;
	
	public static String getPathCliente()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathCliente");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getNameClienteStream()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileCliente");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameAlianzas()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileAlianzas");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNamePaises()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFilePaises");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameProvincias()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileProvincias");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getPathVenta()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathVenta");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getNameVenta()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileVenta");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getPathVuelo()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathVuelo");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getNameVuelo()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileVuelo");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getPathLineaAerea()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathLineaAerea");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameLineaAerea()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileLineaAerea");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameAllAeroLineas()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileAllAeroLineas");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNameAllAeropuertos()throws IOException, FileNotFoundException{
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileAllAeropuertos");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	public static String getNamePathAeropuerto() {
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("nameFileAeropuerto");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static String getPathAeropuerto() {
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathAeropuerto");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	public static String getPathTxt() {
		try{
			config = new Properties();
			config.load(ClassLoader.getSystemResourceAsStream("config.properties"));
			return config.getProperty("pathTxt");
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
}
