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
	
	public Producto saveProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	
	public ArrayList<Producto> findAllProducto(){
		return (ArrayList<Producto>)productoRepository.findAll();		
	}
	public boolean deleteProducto(Long id) {
		try {
			productoRepository.deleteById(id);
			return true;
		}catch(Exception err){
			return false;
		}
	}
	
	public Optional<Producto> findByIdProducto(Long id) {
		return productoRepository.findById(id);
	}	
}
