package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Archivos;
import com.codehard.miscursos.repositories.ArchivosReporitory;

@Service("servicioArchivos")
public class ArchivosServiceImp {
	@Autowired
	@Qualifier("archivosRepository")
	public ArchivosReporitory archivosRepository;

	public Optional<Archivos> getArchivosById(Integer id) {
		return archivosRepository.findById(id);
	}

	public List<Archivos> getArchivosAll() {
		return archivosRepository.findAll();
	}

	public Archivos addArchivos(Archivos archivos) {
		return archivosRepository.saveAndFlush(archivos);
	}

	public Archivos editArchivos(Archivos archivos) {
		return archivosRepository.saveAndFlush(archivos);
	}

	public void deleteArchivos(Integer id) {
		archivosRepository.deleteById(id);
	}
}
