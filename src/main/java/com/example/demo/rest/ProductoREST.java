package com.example.demo.rest;

import java.net.URI;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoREST {
	@Autowired
	private ProductoService productoService;
	
	@PostMapping
	private ResponseEntity<Producto> guardar(@RequestBody Producto producto ){
		Producto temporal =productoService.create(producto);
		try {
			return ResponseEntity.created(new URI("producto"+temporal.getId())).body(temporal);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@GetMapping
	private ArrayList<Producto> ListarProductos(){
		return productoService.getAllProductos();
	}
	
	@DeleteMapping
	private ResponseEntity<Void> EliminarProducto(@RequestBody Producto producto ){
		productoService.delete(producto);
		return ResponseEntity.ok().build();		
	}
	@GetMapping(value="{id}")
	private ResponseEntity<Optional<Producto>> buscarProducto(@PathVariable("id") Long id ){
		return ResponseEntity.ok(productoService.findById(id));		
	}	
}
