package com.formaciondbi.springboot.app.membresia.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formaciondbi.springboot.app.membresia.models.Membresia;
import com.formaciondbi.springboot.app.membresia.models.Usuario;

@Service
public class MembresiaServiceImpl implements MembresiaService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Membresia> findAll() {
		List<Usuario> usuarios= Arrays.asList(clienteRest.getForObject("http://localhost:8001/listar", Usuario[].class))	;
	
		return usuarios.stream().map(p-> new Membresia(p,1)).collect(Collectors.toList());
	}

	@Override
	public Membresia calcMonths(Long id, Integer meses) {
		Map<String, String> pathVariables= new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Usuario usuario = clienteRest.getForObject("http://localhost:8001/listar/{id}", Usuario.class, pathVariables);
		
		return new Membresia(usuario, meses);
	}
	
	@Override
	public Membresia benefits(Long id) {
		Map<String, String> pathVariables= new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Usuario usuario = clienteRest.getForObject("http://localhost:8001/listar/{id}", Usuario.class, pathVariables);
		
		return new Membresia(usuario);
	}
	


}
