package com.com.formaciondbi.springboot.app.usuarios.models.service;

import java.util.List;

import com.com.formaciondbi.springboot.app.usuarios.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	public Usuario findById(Long id);
	
}
