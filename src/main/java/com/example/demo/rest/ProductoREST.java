package com.example.demo.rest;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoREST {
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	private ResponseEntity<ArrayList<Producto>> ListarProductos(){
		return ResponseEntity.ok(productoService.findAllProducto());
	}	
	@PostMapping
	private Producto guardar(@RequestBody Producto producto ){
		return this.productoService.saveProducto(producto);
		
	}
	
	@DeleteMapping(path="/{id}")
	private String EliminarProducto(@PathVariable("id") Long id){
		boolean ok=this.productoService.deleteProducto(id);
		if(ok) {
			return "Se eliminĂ³ el usuario con id " +id;
		}
		return "No se eliminĂ³ el usuario con id " +id;
	}
	@GetMapping(path="/{id}")
	private Optional<Producto> buscarProducto(@PathVariable("id") Long id ){
		return this.productoService.findByIdProducto(id);	
	}	
	@RequestMapping("/error")
	@ResponseBody
	public String getErrorPath() {
		return "<center><h1>Something went wrong</h1></center>";
	}
}
