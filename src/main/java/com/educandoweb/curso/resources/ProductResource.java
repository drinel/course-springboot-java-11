package com.educandoweb.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;           

import com.educandoweb.curso.entities.Product;
import com.educandoweb.curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
//	@RestController simplesmente retorna o objeto e os dados do objeto 
//	são gravados diretamente na resposta HTTP como JSON ou XML.
	
//	@RequestMapping
//	Define a url que quando for requisitada chamara o metodo
	
	@Autowired
	private ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
//	@GetMapping Notação para mapeamento de solicitações HTTP GET em métodos
//	manipuladores específicos.
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findById(id);
		return ResponseEntity.ok(obj);	}
	
	
}

//O termo REST significa Representational State Transfer.
//Nada mais é que um padrão de arquitetura para criar serviços e disponibilizá-los na Web.