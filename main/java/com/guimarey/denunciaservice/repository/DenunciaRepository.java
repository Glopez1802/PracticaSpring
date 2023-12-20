package com.guimarey.denunciaservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guimarey.denunciaservice.entity.Denuncia;



public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
	List<Denuncia> findByTituloContaining(String titulo);
	Denuncia findByTitulo(String titulo);
}
