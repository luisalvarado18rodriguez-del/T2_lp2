package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Producto;

public interface IProducto extends JpaRepository<Producto, Long> {

}
