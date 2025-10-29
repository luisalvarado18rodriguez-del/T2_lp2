package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Proveedor;
import com.example.demo.repository.IProducto;
import com.example.demo.repository.IProveedor;


@Controller
public class VistaController {

	
	@Autowired
	private IProducto iproduc;
	@Autowired
	private IProveedor iprovee;
	
      @GetMapping("/")
      public String index() {
	  return "index";
}
      @GetMapping("/guardarProducto")
  	public String crud(Model model) {
  	    return "ingresar";
  	}
      
      // Guardar producto (POST)
      @PostMapping("/guardarProducto")
      public String guardarProducto(
              @RequestParam("nom_prod") String nombre,
              @RequestParam("stock_actual") int stock,
              @RequestParam("razon_social") String razon,
              @RequestParam("direccion") String direccion) {

         
          Proveedor p = new Proveedor();
          p.setRazon_social(razon);
          p.setDireccion(direccion);
          iprovee.save(p);
        
          Producto prod = new Producto();
          prod.setNombre(nombre);
          prod.setStock(stock);
          prod.setProveedor(p);

         
          iproduc.save(prod);

          
          return "redirect:/Cargar";
      }
      
      
      @GetMapping("/Cargar")
      public String mostrarProductos(Model model) {
          List<Producto> lista = iproduc.findAll();
          model.addAttribute("productos", lista);
          return "consultaProducto"; // 
      }
      
      @GetMapping("/editarProducto")
      public String editarProducto(@RequestParam("id") Long id, Model model) {
          Producto prod = iproduc.findById(id).orElse(null);
          if (prod == null) {
              return "redirect:/Cargar"; 
          }
          model.addAttribute("producto", prod);
          return "editarProducto"; 
      }
      
      @PostMapping("/actualizarProducto")
      public String actualizarProducto(
              @RequestParam("idprod") Long id,
              @RequestParam("nombre") String nombre,
              @RequestParam("stock") int stock,
              @RequestParam("razon") String razon,
              @RequestParam("direccion") String direccion) {

          Producto prod = iproduc.findById(id).orElse(null);
          if (prod != null) {
              prod.setNombre(nombre);
              prod.setStock(stock);

              Proveedor prov = prod.getProveedor();
              prov.setRazon_social(razon);
              prov.setDireccion(direccion);
              iprovee.save(prov);

              iproduc.save(prod);
          }

          return "redirect:/Cargar"; 
      }

      
}
