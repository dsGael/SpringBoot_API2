package com.formaciondbi.springboot.app.membresia.models.dto;

import com.formaciondbi.springboot.app.membresia.models.Membresia;

public class MembresiaBeneficiosDTO {

	  	private String nombreUsuario;
	    private String tipoMembresia;
	    private String[] beneficios;

	    public  MembresiaBeneficiosDTO(Membresia membresia) {
	        this.nombreUsuario = membresia.getUsuario().getNombre();
	        this.tipoMembresia = membresia.getUsuario().getMembresia();
	        this.beneficios = membresia.getBeneficios();
	    }

	    // Getters
	    public String getNombreUsuario() { return nombreUsuario; }
	    public String getTipoMembresia() { return tipoMembresia; }
	    public String[] getBeneficios() { return beneficios; }
	
}
