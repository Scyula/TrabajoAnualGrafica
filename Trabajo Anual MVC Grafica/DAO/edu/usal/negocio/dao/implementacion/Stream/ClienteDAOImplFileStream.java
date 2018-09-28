package edu.usal.negocio.dao.implementacion.Stream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.PropertiesUtil;

/*public class ClienteDAOImplFileStream implements ClienteDAO {
	private File file;
	private ObjectInputStream objInput;
	private ObjectOutputStream objOutput;
	private FileOutputStream fileOut;
	private FileInputStream fileIn;

	@Override
	public boolean addCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista = this.getAllCliente();
		lista.add(cliente);
		this.saveAllCliente(lista);
		return true;
	}

	@Override
	public boolean updateCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista = this.getAllCliente();
		for(Cliente c : lista){
			if(c.getCuitcuil().equals(cliente.getCuitcuil())){
				lista.set(lista.indexOf(c), cliente);
				this.saveAllCliente(lista);
				return true;
				}
		}
		return false;
	}

	@Override
	public boolean deleteCliente(Cliente cliente) throws FileNotFoundException, IOException {
		List<Cliente> lista = this.getAllCliente();
		for(Cliente c : lista){
			if(c.getCuitcuil().equals(cliente.getCuitcuil())){
				lista.remove(c);
				this.saveAllCliente(lista);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Cliente> getAllCliente() throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathCliente(),PropertiesUtil.getNameClienteStream());
		if(!file.exists()){
			file = new File(PropertiesUtil.getPathCliente());
			file.mkdirs();
			file= new File(PropertiesUtil.getPathCliente(), PropertiesUtil.getNameClienteStream());
			file.createNewFile();
			this.saveAllCliente(new ArrayList<Cliente>());
			return new ArrayList<Cliente>();
		}
		this.fileIn = new FileInputStream(this.file);
		this.objInput = new ObjectInputStream(this.fileIn);
		try {
			List<Cliente> lista = (ArrayList<Cliente>) objInput.readObject();
			this.fileIn.close();
			this.objInput.close();
			return lista;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void saveAllCliente(List<Cliente> list) throws FileNotFoundException, IOException {
		this.file= new File(PropertiesUtil.getPathCliente(),PropertiesUtil.getNameClienteStream());
		this.fileOut = new FileOutputStream(file);
		this.objOutput = new ObjectOutputStream(fileOut);
		this.objOutput.writeObject(list);
		this.objOutput.close();
	}
}*/
