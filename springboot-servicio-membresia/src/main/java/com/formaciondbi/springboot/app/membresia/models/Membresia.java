package com.formaciondbi.springboot.app.membresia.models;

public class Membresia {

	private Usuario usuario;
	private Integer meses;
	
	public Integer getMeses() {
		return meses;
	}


	public void setMeses(Integer meses) {
		this.meses = meses;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
		this.meses=1;
	}




	public Membresia(Usuario usuario, Integer meses) {
		this.usuario = usuario;
		this.meses = meses;
	}
	
	public Membresia(Usuario usuario) {
		this.usuario=usuario;
		this.meses=1;
		
	}
		

	public Membresia() {
	
	}
	
	public Double getTotal() {
		int precioM;
		
		 switch (usuario.getMembresia().toUpperCase()) {
         case "GOLD":
             precioM=500 ;
             return precioM*meses.doubleValue() ;
         case "SILVER":
        	 precioM=300;
             return precioM*meses.doubleValue() ;
         case "BRONZE":
        	 precioM=200 ;
             return precioM*meses.doubleValue() ;
          
		 }
		 return null;
		 
		
	}
	
	public String[] getBeneficios() {
	    switch (usuario.getMembresia().toUpperCase()) {
	        case "GOLD":
	            return new String[]{
	                "Acceso ilimitado",
	                "Soporte premium 24/7",
	                "Descuentos del 30%",
	                "Hola papus"
	            };
	        case "SILVER":
	            return new String[]{
	                "Acceso a la mayoría de funciones",
	                "Soporte estándar",
	                "Descuentos del 15%"
	            };
	        case "BRONZE":
	            return new String[]{
	                "Acceso básico",
	                "Soporte limitado",
	                "Descuentos del 5%"
	            };
	        default:
	            return new String[]{"Membresía no válida"};
	    }
	}


	
	
	
	
}
