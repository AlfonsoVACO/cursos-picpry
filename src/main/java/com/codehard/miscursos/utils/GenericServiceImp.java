package com.codehard.miscursos.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviceGeneric")
public class GenericServiceImp<T extends Object> {

	@Autowired
	@Qualifier("genericRepository")
	private GenericRepository<T> genericRepository;

	public T getById(Integer id) {
		return genericRepository.findById(id).get();
	}

}
