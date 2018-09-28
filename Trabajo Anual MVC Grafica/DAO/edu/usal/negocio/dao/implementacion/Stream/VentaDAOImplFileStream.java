package edu.usal.negocio.dao.implementacion.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Venta;
import edu.usal.util.PropertiesUtil;

public class VentaDAOImplFileStream implements VentaDAO {
	private File file;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private FileOutputStream fileOut;
	private FileInputStream fileIn;
	
	@Override
	public boolean addVenta(Venta venta) throws FileNotFoundException, IOException {
		List<Venta> lista = this.getAllVenta();
		lista.add(venta);
		this.saveAllVenta(lista);
		return true;
	}

	@Override
	public boolean updateVenta(Venta venta) throws FileNotFoundException, IOException {
		List<Venta> lista = this.getAllVenta();
		for(Venta v : lista){
			if(v.getId_venta()==venta.getId_venta()){
				lista.remove(v);
				lista.add(venta);
				this.saveAllVenta(lista);
				return true;
				}
		}
		return false;
	}

	@Override
	public boolean deleteVentas(Venta venta) throws FileNotFoundException, IOException {
		List<Venta> lista = this.getAllVenta();
		for(Venta v : lista){
			if(v.getId_venta()==venta.getId_venta()){
				lista.remove(v);
				this.saveAllVenta(lista);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Venta> getAllVenta() throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathVenta(),PropertiesUtil.getNameVenta());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathVenta());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathVenta(), PropertiesUtil.getNameVenta());
			file.createNewFile();
			this.saveAllVenta(new ArrayList<Venta>());
			return new ArrayList<Venta>();
		}
		this.fileIn = new FileInputStream(this.file);
		this.objInput = new ObjectInputStream(this.fileIn);
		try {
			List<Venta> lista = (ArrayList<Venta>) objInput.readObject();
			this.fileIn.close();
			this.objInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void saveAllVenta(List<Venta> list) throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathVenta(),PropertiesUtil.getNameVenta());
		this.fileOut = new FileOutputStream(file);
		this.objOutput = new ObjectOutputStream(fileOut);
		this.objOutput.writeObject(list);
		this.objOutput.close();
	}

}
