package ar.edu.unju.edm.Servicie.Interface;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Compra;


@Service
public interface ICompraService {
	public void guardarCompra(Compra unaCompra );
	public List<Compra> obtenerCompras();
	public Compra crearCompra(); 
}
