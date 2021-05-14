package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

@Component	
public class Producto {
	
	public int codigo, stock;
	public String nombre, marca;
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