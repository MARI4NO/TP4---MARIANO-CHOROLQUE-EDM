package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.edm.model.Cliente;

@Repository
public interface IClienteDAO extends CrudRepository <Cliente, Integer> {
	@Query(value = "SELECT * FROM clientes ORDER BY nro_documento",nativeQuery = true)
    public List<Cliente> obtenerClientes();
	public Optional<Cliente>findByNroDocumento(int dni);
}
