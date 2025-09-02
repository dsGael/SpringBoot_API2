package com.formaciondbi.springboot.app.membresia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formaciondbi.springboot.app.membresia.models.Membresia;
import com.formaciondbi.springboot.app.membresia.models.dto.MembresiaBeneficiosDTO;
import com.formaciondbi.springboot.app.membresia.models.dto.MembresiaMesesDTO;
import com.formaciondbi.springboot.app.membresia.models.service.MembresiaService;

@RestController
public class MembresiaController {
	
	@Autowired
	@Qualifier("serviceRestTemplate")
	//@Qualifier("serviceFeign")
	private MembresiaService membresiaService;
	
	@GetMapping("/listar")
	public List<Membresia> listar(){
		return membresiaService.findAll();
	}

	@GetMapping("/listar/{id}/beneficios")
	public MembresiaBeneficiosDTO benefits(@PathVariable Long id) {
	    Membresia m = membresiaService.benefits(id);
	    return new MembresiaBeneficiosDTO(m);
	}
	
	@GetMapping("/listar/{id}/meses/{meses}")
	public MembresiaMesesDTO detalle(@PathVariable Long id, @PathVariable Integer meses) {
	    Membresia m = membresiaService.calcMonths(id, meses);
	    return new MembresiaMesesDTO(m);
	    
	}
	

	
	

	
	
}
