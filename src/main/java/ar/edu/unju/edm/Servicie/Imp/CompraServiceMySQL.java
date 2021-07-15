package ar.edu.unju.edm.Servicie.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Servicie.Interface.ICompraService;
import ar.edu.unju.edm.model.Compra;
import ar.edu.unju.edm.repository.ICompraDAO;

@Service
@Qualifier("bdimp")
public class CompraServiceMySQL implements ICompraService{
	@Autowired
	ICompraDAO CompraDAO;
	
	@Autowired
	Compra unaCompra;
	
	@Override
	public void guardarCompra(Compra unaCompra) {
		// TODO Auto-generated method stub
		CompraDAO.save(unaCompra);
	}

	@Override
	public List<Compra> obtenerCompras() {
		// TODO Auto-generated method stub
		return (List<Compra>)CompraDAO.findAll();
	}

	@Override
	public Compra crearCompra() {
		// TODO Auto-generated method stub
		return unaCompra;
	}

}
