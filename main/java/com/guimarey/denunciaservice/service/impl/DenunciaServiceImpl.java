package com.guimarey.denunciaservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guimarey.denunciaservice.entity.Denuncia;
import com.guimarey.denunciaservice.repository.DenunciaRepository;
import com.guimarey.denunciaservice.service.DenunciaService;


@Service
public class DenunciaServiceImpl implements DenunciaService {

	
	@Autowired
	private DenunciaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Denuncia> findAll(Pageable page) {
		try {
			return repository.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Denuncia findById(int id) {
		try {
			return repository.findById(id).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Denuncia findByTitulo(String nombre) {
		try {
			return repository.findByTitulo(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Denuncia> findByTituloContaining(String nombre, Pageable page) {
		try {
			return repository.findByTituloContaining(nombre);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	@Override
	@Transactional
	public Denuncia create(Denuncia obj) {
		try {
			return repository.save(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	@Override
	@Transactional
	public Denuncia update(Denuncia obj) {
		try {
			Denuncia denunciaDb=repository.findById(obj.getId()).orElse(null);
			if(denunciaDb==null) {
				return null;
			}
			denunciaDb.setDni(obj.getDni());
			denunciaDb.setFecha(obj.getFecha());
			denunciaDb.setDireccion(obj.getDireccion());
			denunciaDb.setTitulo(obj.getTitulo());
			denunciaDb.setDescripcion(obj.getDescripcion());
		    //docenteDb.setApellidopaterno(obj.getApellidopaterno());
			//docenteDb.setApellidomaterno(obj.getApellidomaterno());
			
			return repository.save(denunciaDb);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public int delete(int id) {
		try {
			Denuncia denunciaDb=repository.findById(id).orElse(null);
			if(denunciaDb==null) {
				return 0;
			}else {
				repository.delete(denunciaDb);
				return 1;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	

	

}
