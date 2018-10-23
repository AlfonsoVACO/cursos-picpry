package com.codehard.miscursos.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service("servicioEllPero")
public class GenericServiceImp<T> implements GenericService<T>{
	
	@Autowired
	@Qualifier("genericRepository")
	private GenericDao<T> genericDao;

	@Override
	public T findById(int id) {
		return genericDao.findById(id).get();
	}

	@Override
	public T update(T entity) {
		return genericDao.save(entity);
	}

	@Override
	public void delete(T entity) {
		genericDao.delete(entity);
	}
	

}
