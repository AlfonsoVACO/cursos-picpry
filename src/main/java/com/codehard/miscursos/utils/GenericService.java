package com.codehard.miscursos.utils;

public interface GenericService<T> {
	public T getById(Integer id);
}
