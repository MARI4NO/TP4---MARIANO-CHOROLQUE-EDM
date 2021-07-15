package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.Servicie.Interface.ICompraService;
import ar.edu.unju.edm.model.Compra;


@Controller
public class CompraController {
	@Autowired
	@Qualifier("bdimp")
	ICompraService CompraService;
	
	@PostMapping("/compra/guardar")
	public String guardarCompra(Model Modelo,@ModelAttribute("unaCompra")Compra unaCompra) {
		return "index";
	}
	
}
