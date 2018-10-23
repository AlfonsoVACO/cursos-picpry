package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Categoria;
import com.codehard.miscursos.repositories.CategoriaRepository;

@Service("servicioCategoria")
public class CategoriaServiceImp {
	@Autowired
	@Qualifier("categoriaRepository")
	public CategoriaRepository categoriaRepository;

	public Optional<Categoria> getCategoriaById(Integer id) {
		return categoriaRepository.findById(id);
	}

	public List<Categoria> getCategoriaAll() {
		return categoriaRepository.findAll();
	}

	public Categoria addCategoria(Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}

	public Categoria editCategoria(Categoria categoria) {
		return categoriaRepository.saveAndFlush(categoria);
	}

	public void deleteCategoria(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
