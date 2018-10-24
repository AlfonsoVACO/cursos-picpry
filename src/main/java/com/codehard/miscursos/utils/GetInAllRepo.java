package com.codehard.miscursos.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GetInAllRepo<T extends Object> {

	private T type;
	
	@Autowired
	@Qualifier("serviceGeneric")
	public GenericServiceImp<T> serviceGeneric;
	
	public GetInAllRepo(T type) {
		this.type = type;
	}
	
	public T getClassById(Integer id) {
		return serviceGeneric.getById(id);
	}
	
}
