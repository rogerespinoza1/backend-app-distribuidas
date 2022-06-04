package com.example.demo.service;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	private ProductoRepository productoRepository;
	
	public Producto create(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public ArrayList<Producto> getAllProductos(){
		return (ArrayList<Producto>)productoRepository.findAll();		
	}
	public void delete(Producto producto) {
		productoRepository.delete(producto);
	}
	
	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}	
}
