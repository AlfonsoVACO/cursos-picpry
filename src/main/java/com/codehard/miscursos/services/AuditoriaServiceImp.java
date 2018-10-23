package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Auditoria;
import com.codehard.miscursos.repositories.AuditoriaRepository;

@Service("servicioAuditoria")
public class AuditoriaServiceImp {
	@Autowired
	@Qualifier("auditoriaRepository")
	public AuditoriaRepository auditoriaRepository;

	public Optional<Auditoria> getAuditoriaById(Integer id) {
		return auditoriaRepository.findById(id);
	}

	public List<Auditoria> getAuditoriaAll() {
		return auditoriaRepository.findAll();
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		return auditoriaRepository.saveAndFlush(auditoria);
	}

	public Auditoria editAuditoria(Auditoria auditoria) {
		return auditoriaRepository.saveAndFlush(auditoria);
	}

	public void deleteAuditoria(Integer id) {
		auditoriaRepository.deleteById(id);
	}
}
