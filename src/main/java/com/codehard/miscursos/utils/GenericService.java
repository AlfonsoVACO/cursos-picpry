package com.codehard.miscursos.utils;

public interface GenericService <T>{
	public T findById(int id);  
    public T update(T entity);     
    public void delete(T entity); 
}
