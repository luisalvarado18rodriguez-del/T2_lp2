package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idprod;

    @Column(name = "nom_prod")
    private String nombre;

    @Column(name = "stock_actual")
    private int stock;

    // Relación con Proveedor
    @ManyToOne
    @JoinColumn(name = "id_prov") // FK que apunta a Proveedor
    private Proveedor proveedor;

    public Producto() {}

    public Producto(String nombre, int stock, Proveedor proveedor) {
        this.nombre = nombre;
        this.stock = stock;
        this.proveedor = proveedor;
    }

    public Long getIdprod() {
        return idprod;
    }

    public void setIdprod(Long idprod) {
        this.idprod = idprod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
