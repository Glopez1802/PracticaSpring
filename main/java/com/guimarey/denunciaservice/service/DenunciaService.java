package com.guimarey.denunciaservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.guimarey.denunciaservice.entity.Denuncia;



public interface DenunciaService {
	public List<Denuncia> findAll(Pageable page);
	public Denuncia findById(int id);
	public Denuncia findByTitulo(String nombre);
	public List<Denuncia> findByTituloContaining(String nombre, Pageable page);
	public Denuncia create(Denuncia obj);
	public Denuncia update(Denuncia obj);
	public int delete(int id);
	
}
