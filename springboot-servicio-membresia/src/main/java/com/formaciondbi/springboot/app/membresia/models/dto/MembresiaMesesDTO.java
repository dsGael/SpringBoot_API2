package com.formaciondbi.springboot.app.membresia.models.dto;

import com.formaciondbi.springboot.app.membresia.models.Membresia;

public class MembresiaMesesDTO {

    private String nombreUsuario;
    private String correoUsuario;
    private String tipoMembresia;
    private Integer meses;
    private Double total;

    public MembresiaMesesDTO(Membresia membresia) {
        this.nombreUsuario = membresia.getUsuario().getNombre();
        this.correoUsuario=membresia.getUsuario().getEmail();
        this.tipoMembresia = membresia.getUsuario().getMembresia();
        this.meses = membresia.getMeses();
        this.total = membresia.getTotal();
    }

    // Getters
    public String getNombreUsuario() { return nombreUsuario; }
    public String getCorreoUsuario() {return correoUsuario;}
    public String getTipoMembresia() { return tipoMembresia; }
    public Integer getMeses() { return meses; }
    public Double getTotal() { return total; }
}