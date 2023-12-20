package com.guimarey.denunciaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.guimarey.denunciaservice.entity.Denuncia;
import com.guimarey.denunciaservice.service.impl.DenunciaServiceImpl;



@RestController
@RequestMapping("/v1/denuncia")
public class DenunciaController {
	@Autowired
	private DenunciaServiceImpl service;
	
	@GetMapping() 
	public ResponseEntity<List<Denuncia>> getAll(Pageable page){
		List<Denuncia> denuncia= service.findAll(page);
		return ResponseEntity.status(HttpStatus.OK).body(denuncia);
	}
	
	@GetMapping(value="/{id}") 
	public ResponseEntity<Denuncia> getById(@PathVariable("id") int id) {
		Denuncia denuncia = service.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(denuncia);
	}
	
	
	@PostMapping 
	public ResponseEntity<Denuncia> create(@RequestBody Denuncia denuncia) {
		Denuncia docenteDb=service.create(denuncia);
		return ResponseEntity.status(HttpStatus.CREATED).body(docenteDb);
	}
	
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Denuncia> update(@RequestBody Denuncia denuncia) {
		Denuncia denunciaDb=service.update(denuncia);
		return ResponseEntity.status(HttpStatus.OK).body(denunciaDb);
	}
	
	
	@DeleteMapping(value="/{id}")
	public int delete(@PathVariable("id") int id){
		return service.delete(id);
	}
}
