package ar.edu.unju.edm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component	
@Entity
@Table(name = "producto")
public class Producto {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int codigo;
	@Column
	public int stock;
	@Column
	public String nombre, marca;
	@Column
	public double precio;

	public Producto() {
		super();
	}
	
	public Producto(int codigo, int stock, String nombre, String marca, double precio) {
		super();
		this.codigo = codigo;
		this.stock = stock;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}


}
