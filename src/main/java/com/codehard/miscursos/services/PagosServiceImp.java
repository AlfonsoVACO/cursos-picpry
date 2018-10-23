package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Pagos;
import com.codehard.miscursos.repositories.PagosRepository;

@Service("servicioPagos")
public class PagosServiceImp {
	@Autowired
	@Qualifier("pagosRepository")
	public PagosRepository pagosRepository;

	public Optional<Pagos> getPagosById(Integer id) {
		return pagosRepository.findById(id);
	}

	public List<Pagos> getPagosAll() {
		return pagosRepository.findAll();
	}

	public Pagos addPagos(Pagos pagos) {
		return pagosRepository.saveAndFlush(pagos);
	}

	public Pagos editPagos(Pagos pagos) {
		return pagosRepository.saveAndFlush(pagos);
	}

	public void deletePagos(Integer id) {
		pagosRepository.deleteById(id);
	}
}
