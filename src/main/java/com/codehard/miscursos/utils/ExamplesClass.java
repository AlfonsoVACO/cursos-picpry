package com.codehard.miscursos.utils;

import java.lang.reflect.Field;

import org.springframework.data.domain.Example;

public class ExamplesClass <T>{
	private T classe;
	private Object[] value;
	
	public ExamplesClass(T classe, Object[] value) {
		this.classe = classe;
		this.value = value;
	}

	public Example<T> getExample() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<? extends Object> nuevaClase = this.classe.getClass();
		Field field = nuevaClase.getDeclaredField( (String) value[0] );
		field.setAccessible(true);
		field.set( this.classe, value[1] );
		return (Example<T>) Example.of( this.classe );
	}

}
