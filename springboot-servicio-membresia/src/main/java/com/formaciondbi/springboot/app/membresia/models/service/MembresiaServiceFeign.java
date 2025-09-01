package com.formaciondbi.springboot.app.membresia.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formaciondbi.springboot.app.membresia.clientes.UsuarioClienteRest;
import com.formaciondbi.springboot.app.membresia.models.Membresia;
import com.formaciondbi.springboot.app.membresia.models.Usuario;

@Service("serviceFeign")
@Primary
public class MembresiaServiceFeign implements MembresiaService {

    @Autowired
    private UsuarioClienteRest clienteFeign;

    @Override
    public List<Membresia> findAll() {
        List<Usuario> usuarios = clienteFeign.listar();

        return usuarios.stream()
                .map(usuario -> new Membresia(usuario, 1)) // 1 mes por default
                .collect(Collectors.toList());
    }

    @Override
    public Membresia calcMonths(Long id, Integer meses) {
        Usuario usuario = clienteFeign.detalle(id);
        return new Membresia(usuario, meses);
    }

    @Override
    public Membresia benefits(Long id) {
        Usuario usuario = clienteFeign.detalle(id);
        return new Membresia(usuario);
    }
}
