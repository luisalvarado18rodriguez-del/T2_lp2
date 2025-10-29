package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Proveedor;

public interface IProveedor extends JpaRepository<Proveedor, Integer>{

}
