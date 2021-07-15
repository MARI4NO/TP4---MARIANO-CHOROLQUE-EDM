package ar.edu.unju.edm.Servicie.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Servicie.Interface.IClienteServicio;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.repository.IClienteDAO;

@Service 
@Qualifier("bdimp")
public class ClienteServiceMySQL implements IClienteServicio{
	
	@Autowired
	Cliente unCliente;

	@Autowired
	IClienteDAO ClienteDAO;
	
	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		ClienteDAO.save(unCliente);
	}

	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return ClienteDAO.obtenerClientes();
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public void modificarCliente(Cliente unCliente) throws Exception {
		// TODO Auto-generated method stub
		Cliente Encontrado =buscarCliente(unCliente) ;
		cambiarCliente(unCliente,Encontrado);
		ClienteDAO.save(Encontrado);
	}

	@Override
	public void eliminarCliente(Cliente unCliente) throws Exception {
		// TODO Auto-generated method stub
		Cliente Encontrado=buscarCliente(unCliente);
		ClienteDAO.delete(Encontrado);
		
	}

	@Override
	public Cliente buscarCliente(Cliente unCliente) throws Exception  {
		// TODO Auto-generated method stub
		return ClienteDAO.findById(unCliente.getIdCliente()).orElseThrow(()->new Exception("Cliente no encontrado"));
		
	}
	
	public void cambiarCliente(Cliente DESDE, Cliente HACIA) {
		HACIA.setCodigoAreaTelefono(DESDE.getCodigoAreaTelefono());
		HACIA.setEdad(DESDE.getEdad());
		HACIA.setEmail(DESDE.getEmail());
		HACIA.setFechaNacimiento(DESDE.getFechaNacimiento());
		HACIA.setFechaUltimaCompra(DESDE.getFechaUltimaCompra());
		HACIA.setNombreApellido(DESDE.getNombreApellido());
		HACIA.setNroDocumento(DESDE.getNroDocumento());
		HACIA.setNroTelefono(DESDE.getNroTelefono());
		HACIA.setPassword(DESDE.getPassword());
		HACIA.setTipoDeDocumento(DESDE.getTipoDeDocumento());
		
	}

	@Override
	public Cliente buscarClientePorDni(int dni) throws Exception {
		// TODO Auto-generated method stub
	 return ClienteDAO.findByNroDocumento(dni).orElseThrow(()->new Exception("Cliente no encontrado"));
	}

	@Override
	public Cliente buscarCliente2(Integer id) {
		// TODO Auto-generated method stub
		Cliente encotrado=ClienteDAO.findById(id).orElse(null);
		return encotrado;
	}
}
