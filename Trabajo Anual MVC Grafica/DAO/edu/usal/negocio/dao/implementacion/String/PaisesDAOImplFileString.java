package edu.usal.negocio.dao.implementacion.String;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.PaisesDAO;
import edu.usal.util.PropertiesUtil;

public class PaisesDAOImplFileString implements PaisesDAO {
	private File file;
	private Scanner scanner;
	
	@Override
	public Hashtable<Integer, String> leerPaises() throws FileNotFoundException, IOException {
		file = new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getNamePaises());
		scanner= new Scanner(file);
		Hashtable<Integer, String> list = new Hashtable<Integer, String>();
		while (scanner.hasNextLine()){
			String[] straux = scanner.nextLine().split("-");		
			list.put(Integer.valueOf(straux[0]), straux[1]);
		}
		return list;
	}

}
