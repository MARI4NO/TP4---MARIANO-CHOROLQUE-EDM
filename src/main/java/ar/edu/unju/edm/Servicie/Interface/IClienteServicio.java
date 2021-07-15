package ar.edu.unju.edm.Servicie.Interface;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Cliente;

//comportamiento de la clase que la implementa
@Service
public interface IClienteServicio {

	public void guardarCliente(Cliente unCliente );
	public List<Cliente> obtenerClientes();
	public Cliente crearCliente(); 
	public void modificarCliente (Cliente unCliente) throws Exception;
	public void eliminarCliente (Cliente unCliente) throws Exception;
	public Cliente buscarCliente (Cliente unCliente) throws Exception;
	public Cliente buscarClientePorDni(int dni) throws Exception;
	public Cliente buscarCliente2 (Integer id);
}
