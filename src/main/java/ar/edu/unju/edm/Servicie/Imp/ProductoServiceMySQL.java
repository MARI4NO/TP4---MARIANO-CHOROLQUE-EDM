package ar.edu.unju.edm.Servicie.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Servicie.Interface.IProductoServicio;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IProductoDAO;

@Qualifier("bdimp")
@Service
public class ProductoServiceMySQL implements IProductoServicio{

	@Autowired
	Producto unProducto;
	
	@Autowired
	IProductoDAO ProductoDAO;
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		ProductoDAO.save(unProducto);
	}

	@Override
	public Producto ultimoProducto() {
		// TODO Auto-generated method stub
		List<Producto> Productos = (List<Producto>) ProductoDAO.findAll();
		if(Productos.size()==0) {
			return null;
		}
		int indice = Productos.size()-1;
		return Productos.get(indice);
	}

	@Override
	public void eliminarProducto(int codigo) {
		// TODO Auto-generated method stub
		Producto encontrado = ProductoDAO.findById(codigo).orElse(null);
		if(encontrado!=null) {
			ProductoDAO.delete(encontrado);
		}
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
		return (List<Producto>)ProductoDAO.findAll();
	}

	@Override
	public Producto buscarProducto(Integer codigo) {
		// TODO Auto-generated method stub
		Producto encontrado = ProductoDAO.findById(codigo).orElse(null);
		return encontrado;
	}
}
