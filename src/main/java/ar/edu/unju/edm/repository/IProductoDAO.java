package ar.edu.unju.edm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;

@Repository
public interface IProductoDAO extends CrudRepository <Producto ,Integer>{
	//@Query(value = "SELECT * FROM productos ORDER BY codigo DESC",nativeQuery = true)
}
