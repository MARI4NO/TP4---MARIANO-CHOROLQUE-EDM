package ar.edu.unju.edm.Servicie.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface IProductoServicio {
	public void guardarProducto(Producto unProducto);
	public Producto ultimoProducto ();
	public void eliminarProducto (int codigo);
	public void modificarProducto (int codigo);
	public Producto nuevoProducto ();
	public List<Producto> obtenerTodos ();
}




