package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.Servicie.IClienteServicio;

@Controller 
public class ClienteController {
	
	@Autowired
	IClienteServicio ClienteServicio;
	
	@GetMapping("/cliente/mostrar")
		public String crearCliente(Model modelo) {
			modelo.addAttribute("modCliente", ClienteServicio.crearCliente());
			modelo.addAttribute("liCliente",ClienteServicio.obtenerClientes());
			return "cliente";
		}
	@PostMapping("/cliente/guardar")
		public String guardarCliente(@ModelAttribute("modCliente") Cliente unCliente, Model modelo ){
				unCliente.generarEdad();
				ClienteServicio.guardarCliente(unCliente);
				return "redirect:/cliente/mostrar";
			
		}
	
	
}
