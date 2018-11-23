package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Empresa;
import com.codehard.miscursos.repositories.EmpresaRepository;

@Service("servicioEmpresa")
public class EmpresaServiceImp {
	@Autowired
	@Qualifier("empresaRepository")
	public EmpresaRepository empresaRepository;

	public Optional<Empresa> getEmpresaById(Integer id) {
		return empresaRepository.findById(id);
	}

	public List<Empresa> getEmpresaAll() {
		return empresaRepository.findAll();
	}

	public Empresa addEmpresa(Empresa empresa) {
		return empresaRepository.saveAndFlush(empresa);
	}

	public Empresa editEmpresa(Empresa empresa) {
		return empresaRepository.saveAndFlush(empresa);
	}

	public void deleteEmpresa(Integer id) {
		empresaRepository.deleteById(id);
	}
}
