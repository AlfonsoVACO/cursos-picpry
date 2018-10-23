package com.codehard.miscursos.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class GetInAllRepo <T>{
	private Class<T> type;
	
	@Autowired
	@Qualifier("servicioEllPero")
	private GenericServiceImp< T > genericServiceImp;
	
	/*public GetInAllRepo() {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
	}*/
	
	@SuppressWarnings("unchecked")
	public T getClassById(Integer id) {
		type = (Class<T>) genericServiceImp.findById(id);
		return (T) type;
	}

}
