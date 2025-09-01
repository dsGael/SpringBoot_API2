package com.formaciondbi.springboot.app.membresia.models.service;

import java.util.List;

import com.formaciondbi.springboot.app.membresia.models.Membresia;

public interface MembresiaService {
	
	public List<Membresia> findAll();
	public Membresia calcMonths(Long id, Integer meses);
	public Membresia benefits(Long id);
}
