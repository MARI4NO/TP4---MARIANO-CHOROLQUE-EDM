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

	@Override
	public void modificarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		for(int i=0;i<listaClientes.size();i++) {
			if(listaClientes.get(i).getNroDocumento() == unCliente.getNroDocumento() ) {
				listaClientes.set(i, unCliente);
				break;
			}
			
		}
		
	}

	@Override
	public void eliminarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		for(int i=0;i<listaClientes.size();i++) {
			if(listaClientes.get(i).getNroDocumento() == unCliente.getNroDocumento() ) {
				listaClientes.remove(i);
				break;
			}
		}
	}

	@Override
	public Cliente buscarCliente(int dni) {
		// TODO Auto-generated method stub
		for(int i=0;i<listaClientes.size();i++) {
			if(listaClientes.get(i).getNroDocumento() == dni ) {
				return listaClientes.get(i);
			}
			
		}
		return null;
	}
	
 
}
