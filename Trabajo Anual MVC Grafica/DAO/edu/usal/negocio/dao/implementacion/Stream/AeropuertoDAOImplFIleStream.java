package edu.usal.negocio.dao.implementacion.Stream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.util.PropertiesUtil;

public class AeropuertoDAOImplFIleStream implements AeropuertoDAO {

	private File file;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private FileOutputStream fileOut;
	private FileInputStream fileIn;

	@Override
	public boolean addAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista = this.getAllAeropuerto();
		lista.add(aeropuerto);
		return true;
	}

	@Override
	public boolean updateAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista = this.getAllAeropuerto();
		for(Aeropuerto aerop : lista){
			if(aerop.getIdAeropuerto().equals(aeropuerto.getIdAeropuerto())){
				lista.remove(aerop);
				lista.add(aeropuerto);
				this.saveAllAeropuerto(lista);
				return true;
				}
		}
		return false;
	}

	@Override
	public boolean deleteAeropuerto(Aeropuerto aeropuerto) throws FileNotFoundException, IOException {
		List<Aeropuerto> lista = this.getAllAeropuerto();
		for(Aeropuerto aerop : lista){
			if(aerop.getIdAeropuerto().equals(aeropuerto.getIdAeropuerto())){
				lista.remove(aerop);
				this.saveAllAeropuerto(lista);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Aeropuerto> getAllAeropuerto() throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathAeropuerto(),PropertiesUtil.getNamePathAeropuerto());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathAeropuerto());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathAeropuerto(), PropertiesUtil.getNamePathAeropuerto());
			file.createNewFile();
			this.saveAllAeropuerto(this.primeraLectura());
			this.file= new File(PropertiesUtil.getPathAeropuerto(), PropertiesUtil.getNamePathAeropuerto());
		}
		this.fileIn = new FileInputStream(this.file);
		this.objInput = new ObjectInputStream(this.fileIn);
		try {
			List<Aeropuerto> lista = (ArrayList<Aeropuerto>) objInput.readObject();
			this.fileIn.close();
			this.objInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void saveAllAeropuerto(List<Aeropuerto> lineaAerea) throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathAeropuerto(),PropertiesUtil.getNamePathAeropuerto());
		this.fileOut = new FileOutputStream(file);
		this.objOutput = new ObjectOutputStream(fileOut);
		this.objOutput.writeObject(lineaAerea);
		this.objOutput.close();
	}
	public boolean reestablecer() throws FileNotFoundException, IOException{
		this.saveAllAeropuerto(this.primeraLectura());
		return true;
	}
	private ArrayList<Aeropuerto> primeraLectura(){
		ArrayList<Aeropuerto> lista = new ArrayList<Aeropuerto>();
		try {
			
			this.file= new File(PropertiesUtil.getPathTxt(), PropertiesUtil.getNameAllAeropuertos());
			Scanner scanner= new Scanner(file);
			while (scanner.hasNextLine()){
				String[] straux = scanner.nextLine().split("-");
				Aeropuerto nueva = new Aeropuerto();
				nueva.setCiudad(straux[0]);
				nueva.setIdAeropuerto(straux[1]);
				nueva.setPais(Integer.parseInt(straux[2]));
				if(nueva.getPais()==9) {
					nueva.setProvincia(Integer.parseInt(straux[3]));
				}else {
					nueva.setProvincia(0);
				}
				lista.add(nueva);
			}
		}catch(EOFException e){
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
