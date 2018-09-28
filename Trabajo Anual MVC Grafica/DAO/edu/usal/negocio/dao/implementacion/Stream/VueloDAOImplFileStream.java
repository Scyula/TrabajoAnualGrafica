package edu.usal.negocio.dao.implementacion.Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public class VueloDAOImplFileStream implements VueloDAO {
	private File file;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private FileOutputStream fileOut;
	private FileInputStream fileIn;

	@Override
	public boolean addVuelo(Vuelo vuelo) throws FileNotFoundException, IOException {
		List<Vuelo> lista = this.getAllVuelo();
		lista.add(vuelo);
		this.saveAllVuelo(lista);
		return true;
	}

	@Override
	public boolean updateVuelo(Vuelo vuelo) throws FileNotFoundException, IOException {
		List<Vuelo> lista = this.getAllVuelo();
		for(Vuelo v : lista){
			if(v.getId_vuelo()==vuelo.getId_vuelo()){
				lista.remove(v);
				lista.add(vuelo);
				this.saveAllVuelo(lista);
				return true;
				}
		}
		return false;
	}

	@Override
	public boolean deleteVuelo(Vuelo vuelo) throws FileNotFoundException, IOException {
		List<Vuelo> lista = this.getAllVuelo();
		for(Vuelo v : lista){
			if(v.getId_vuelo()==vuelo.getId_vuelo()){
				lista.remove(v);
				this.saveAllVuelo(lista);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Vuelo> getAllVuelo() throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathVuelo(),PropertiesUtil.getNameVuelo());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathVuelo());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathCliente(), PropertiesUtil.getNameVuelo());
			file.createNewFile();
			this.saveAllVuelo(new ArrayList<Vuelo>());
			return new ArrayList<Vuelo>();
		}
		this.fileIn = new FileInputStream(this.file);
		this.objInput = new ObjectInputStream(this.fileIn);
		try {
			List<Vuelo> lista = (ArrayList<Vuelo>) objInput.readObject();
			this.fileIn.close();
			this.objInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void saveAllVuelo(List<Vuelo> list) throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathVuelo(),PropertiesUtil.getNameVuelo());
		this.fileOut = new FileOutputStream(file);
		this.objOutput = new ObjectOutputStream(fileOut);
		this.objOutput.writeObject(list);
		this.objOutput.close();
	}

}
