package ar.edu.unju.edm.Servicie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.util.ListaClientes;

@Service
public class ClienteServicioImp implements IClienteServicio {
	
	public List<Cliente> listaClientes = ListaClientes.listaDeClientes;
	
	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		listaClientes.add(unCliente);
	}

	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return listaClientes;
		
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}
	
 
}
