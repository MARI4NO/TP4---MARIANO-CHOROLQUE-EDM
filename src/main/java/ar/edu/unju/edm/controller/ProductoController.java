package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.Servicie.Interface.IProductoServicio;
import ar.edu.unju.edm.model.Producto;

@Controller
public class ProductoController {
	@Qualifier("bdimp")
	
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
	@GetMapping("/Producto/Mostrar")
		public String mostrar(Model modelo) {
			modelo.addAttribute("productos", ProductoServicio.obtenerTodos());
			modelo.addAttribute("error",false);
			return "resultado";
	}
	@PostMapping("/Producto/Guardar")
		public String guardarProducto(@ModelAttribute(name ="Producto")Producto unProducto, Model modelo) {
			ProductoServicio.guardarProducto(unProducto);
			return "redirect:/Producto";
}

}
