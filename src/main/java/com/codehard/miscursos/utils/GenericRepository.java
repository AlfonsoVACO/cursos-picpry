package com.codehard.miscursos.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository<T> implements IGenericRepository<T> {
	
	@PersistenceContext
	private EntityManager em;
	private T type;
	
	public GenericRepository(T type) {
		this.type = type;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findByIdplantel(Integer id) {
		return (T) em.createQuery("SELECT p FROM Plantel p WHERE p.idplantel = :idplantel", (Class<T>) type );
	}
}
