package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Libros;
import com.codehard.miscursos.repositories.LibrosReporitory;

@Service("servicioLibros")
public class LibrosServiceImp {
	@Autowired
	@Qualifier("librosRepository")
	public LibrosReporitory librosRepository;

	public Optional<Libros> getLibrosById(Integer id) {
		return librosRepository.findById(id);
	}

	public List<Libros> getLibrosAll() {
		return librosRepository.findAll();
	}

	public Libros addLibros(Libros libros) {
		return librosRepository.saveAndFlush(libros);
	}

	public Libros editLibros(Libros libros) {
		return librosRepository.saveAndFlush(libros);
	}

	public void deleteLibros(Integer id) {
		librosRepository.deleteById(id);
	}
}
