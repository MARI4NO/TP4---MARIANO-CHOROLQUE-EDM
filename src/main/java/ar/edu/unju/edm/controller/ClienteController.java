package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			modelo.addAttribute("modEditar",false);
			return "cliente";
		}
	@PostMapping("/cliente/guardar")
		public String guardarCliente(@ModelAttribute("modCliente") Cliente unCliente, Model modelo ){
				unCliente.generarEdad();
				ClienteServicio.guardarCliente(unCliente);
				return "redirect:/cliente/mostrar";
			
		}
	@GetMapping ("/cliente/editar/{dni}")
		public String editarCliente(@PathVariable(name="dni") int dni, Model modelo) {
			try{
				Cliente encontrado = ClienteServicio.buscarCliente(dni);
				modelo.addAttribute("modCliente", encontrado);
				modelo.addAttribute("liCliente",ClienteServicio.obtenerClientes());
				modelo.addAttribute("modEditar",true);
				return "cliente";
			}
			catch(Exception E) {
				E.getMessage();
			}
			return "redirect:/cliente/mostrar";
	}
	
	@PostMapping ("/cliente/modificar")
		public String modificarCliente(@ModelAttribute("modCliente") Cliente unCliente){
			unCliente.generarEdad();
			ClienteServicio.modificarCliente(unCliente);
			return "redirect:/cliente/mostrar";
		}

	@GetMapping ("/cliente/eliminar/{dni}")
		public String eliminarCliente(@PathVariable(name="dni") int dni) {
			try{
				Cliente encontrado = ClienteServicio.buscarCliente(dni);
				ClienteServicio.eliminarCliente(encontrado);
			}
			catch(Exception E) {
				E.getMessage();
			}
			return "redirect:/cliente/mostrar";
	}






}


