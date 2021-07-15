package ar.edu.unju.edm.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.edm.Servicie.Interface.IClienteServicio;
import ar.edu.unju.edm.Servicie.Interface.ICompraService;
import ar.edu.unju.edm.Servicie.Interface.IProductoServicio;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Compra;
import ar.edu.unju.edm.model.Producto;


@Controller
public class CompraController {
	
	@Autowired
	@Qualifier("bdimp")
	ICompraService CompraService;
	
	@Autowired
	@Qualifier("bdimp")
	IProductoServicio ProductoService;
	
	@Autowired
	@Qualifier("bdimp")
	IClienteServicio ClienteService;
	
	@PostMapping("/compra/guardar")
	public String guardarCompra(Model Modelo,@RequestParam(name="cantidad") Integer cantidad,@RequestParam(name="cod") Integer cod,@RequestParam(name="cli") Integer cli) {
		Producto encontrado = ProductoService.buscarProducto(cod);
		if(encontrado==null) {
			Modelo.addAttribute("error", true);
		}
		else {
			Cliente encon =ClienteService.buscarCliente2(cli);
			if(encon==null) {
				Modelo.addAttribute("error", true);
			}
			else {
				if(encontrado.getStock()<cantidad) {
					Modelo.addAttribute("error",true);
				}
				else {
					Modelo.addAttribute("error",false);
					Compra comp = CompraService.crearCompra();
					comp.setCiente(encon);
					comp.setProducto(encontrado);
					comp.setCantidad(cantidad);
					comp.setFechaCompra(LocalDate.now());
					CompraService.guardarCompra(comp);
					
					//----------- Actualizar Stock ---------
					
					encontrado.setStock(encontrado.getStock()-cantidad);
					ProductoService.guardarProducto(encontrado);
				}
			}
		}
		Modelo.addAttribute("productos", ProductoService.obtenerTodos());
		return "resultado";
	}
}
