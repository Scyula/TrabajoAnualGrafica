package edu.usal.util; 

import java.util.*;

public class IOGeneral {
	
	public static void pritln(String frase){
		System.out.println(frase);
	}
	
	public static int leerInt(String msjInicio, String msjError){
		IOGeneralDAO.pritln(msjInicio);
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()){
			IOGeneralDAO.pritln(msjError);
			scan.next();
		}
		return scan.nextInt();
	}
	
	public static float leerFloat(String msjInicio, String msjError){
		IOGeneralDAO.pritln(msjInicio);
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextFloat()){
			IOGeneralDAO.pritln(msjError);
			scan.next();
		}
		return scan.nextFloat();
	}
	
	public static double leerDouble(String msjInicio, String msjError){
		IOGeneralDAO.pritln(msjInicio);
		Scanner scan = new Scanner (System.in);
		while(!scan.hasNextDouble()){
			IOGeneralDAO.pritln(msjError);
			scan.next();
		}
		return scan.nextDouble();
	}
	
	public static String leerLinea(String msjInicio){
		IOGeneralDAO.pritln(msjInicio);
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	public static String leerFrase(String msjInicio){
		IOGeneralDAO.pritln(msjInicio);
		Scanner scan = new Scanner (System.in);
		return scan.next();
	}

}
