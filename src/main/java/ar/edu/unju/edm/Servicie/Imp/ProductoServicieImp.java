package ar.edu.unju.edm.Servicie.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Servicie.Interface.IProductoServicio;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.util.ListaProductos;

@Service
public class ProductoServicieImp implements IProductoServicio {
	
	public List<Producto> listaProductos = ListaProductos.listaDeProductos;
	@Autowired
	Producto unProducto;

	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		listaProductos.add(unProducto);
	}

	@Override
	public Producto ultimoProducto() {
		// TODO Auto-generated method stub
		int ult = listaProductos.size()-1;
		return listaProductos.get(ult);
	}

	@Override
	public void eliminarProducto(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarProducto(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto nuevoProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public List<Producto> obtenerTodos() {
		// TODO Auto-generated method stub
		return listaProductos;
	}

	@Override
	public Producto buscarProducto(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
