package ar.edu.unju.edm.Servicie;

import java.util.List;

import org.springframework.stereotype.Service;
import ar.edu.unju.edm.model.Cliente;

//comportamiento de la clase que la implementa
@Service
public interface IClienteServicio {

	public void guardarCliente(Cliente unCliente );
	public List<Cliente> obtenerClientes();
	public Cliente crearCliente(); 
	public void modificarCliente (Cliente unCliente);
	public void eliminarCliente (Cliente unCliente);
	public Cliente buscarCliente (int dni);
	
}
