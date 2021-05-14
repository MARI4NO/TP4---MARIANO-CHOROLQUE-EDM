package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.Servicie.IProductoServicio;
import ar.edu.unju.edm.model.Producto;

@Controller
public class ProductoController {

	@Autowired
	IProductoServicio ProductoServicio;
	
	@GetMapping ("/Producto")
		public String productoMostrar (Model modelo) {
		modelo.addAttribute("Producto", ProductoServicio.nuevoProducto());
		return "producto";
	}
	
	@GetMapping ("/Producto/Ultimo")
		public String productoGuardar (Model modelo) {
		modelo.addAttribute("ultimo", ProductoServicio.ultimoProducto());
		return "ultimo";
	}
	
	@GetMapping ("/Volver")
		public String volver() {
			return "redirect:/Producto";
	}
	
	@PostMapping("/Producto/Guardar")
		public String guardarProducto(@ModelAttribute(name ="Producto")Producto unProducto, Model modelo) {
			ProductoServicio.guardarProducto(unProducto);
			modelo.addAttribute("productos", ProductoServicio.obtenerTodos());
			return "resultado";
}

}
