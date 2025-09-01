package com.formaciondbi.springboot.app.membresia.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formaciondbi.springboot.app.membresia.models.Usuario;

@FeignClient(name = "servicio-usuarios", url = "localhost:8001")
public interface UsuarioClienteRest {
	@GetMapping("/listar")
	public List<Usuario> listar();
	
	@GetMapping("/listar/{id}")
	public Usuario detalle(@PathVariable Long id);

//	@GetMapping("/listar/{id}/beneficios")
//	Membresia benefits(@PathVariable Long id);
//
//	@GetMapping("/listar/{id}/meses/{meses}")
//	Membresia detalle(@PathVariable Long id, @PathVariable Integer meses);

	
}