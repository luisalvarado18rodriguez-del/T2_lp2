package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_prov;
private String razon_social;
private String direccion;
	    
public Proveedor() {
super();
}

public Proveedor(String razon_social, String direccion) {
	super();
	this.razon_social = razon_social;
	this.direccion = direccion;
}


public Long getId_prov() {
	return id_prov;
}

public void setId_prov(Long id_prov) {
	this.id_prov = id_prov;
}

public String getRazon_social() {
	return razon_social;
}

public void setRazon_social(String razon_social) {
	this.razon_social = razon_social;
}

public String getDireccion() {
	return direccion;
}

public void setDireccion(String direccion) {
	this.direccion = direccion;
}
	
	    
	    
}
