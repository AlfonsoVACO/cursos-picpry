package com.codehard.miscursos.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codehard.miscursos.modelos.Plantel;

public class MapToClass <T>{
	
	private T objClass;
	private Map<String,Object> mapa;
	private Map<Object,Object[]> lstIdesExternos;
	private String packages;
	
	@SuppressWarnings("rawtypes")
	private Map<Object, JpaRepository> mapasRepo;
	
	public MapToClass(T clase) {
		this.objClass = clase;
	}
	
	@SuppressWarnings("rawtypes")
	public void setConfiguration(
			Map<String,Object> mapa, 
			Map<Object, JpaRepository> mapasRepo,
			String packages) {
		
		this.lstIdesExternos = new HashMap<>();
		this.mapa = mapa;
		this.packages = packages;
		this.mapasRepo = mapasRepo;
	}

	public void getTogas() {
		this.mapasRepo.forEach( ( k , v )->{
			lstIdesExternos.forEach( (nombreclase, idnombre) ->{
				//System.out.println(k.toString());
				//System.out.println(k.getClass().toString());				
				if(k.getClass().getSimpleName().equals(nombreclase)) {
					Class<? extends Object> clase = objClass.getClass();
					System.out.println(nombreclase +" => " +idnombre[0].toString() + " => "+idnombre[1].toString());
					try {
						Field field = clase.getDeclaredField(idnombre[0].toString());
						field.setAccessible(true);
						//Integer id = Integer.parseInt( idnombre[1].toString() );
						//getClassTypeOrg(field, nombreclase.toString(), id );
					} catch (NoSuchFieldException | SecurityException | IllegalArgumentException  e) {
						e.printStackTrace();
					} 
				}
			});
			
		});
	}
	
	public T getClassMap() {
		mapa.forEach((k , v) -> {
			Class<? extends Object> clase = objClass.getClass();
			Field[] fields = clase.getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				if( field.getName().equals(k) ) {
					if( isClassOther( field ) ) {
						try {
							field.set(this.objClass, getTypeAction(field, v));
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}else {
						lstIdesExternos.put(
								field.getType().getSimpleName(), 
								new Object[] {  k, getTypeAction(field, v) } ); // Clase, [idnombre, valorid]
					}
				}
			}
		});
		
		getTogas();
		return this.objClass;
	}
	
	private boolean isClassOther(Field field){
		return field.getType().getName().contains( this.packages ) ? false : true;
	}
	
	private Object getTypeAction(Field field, Object value) {
		switch (field.getType().getSimpleName()) {
		case "Boolean":
			return Boolean.parseBoolean(value.toString());
		case "Byte":
			return Byte.parseByte(value.toString());
		case "Float":
			return Float.parseFloat(value.toString());
		case "Long":
			return Long.parseLong(value.toString());
		case "Integer":
			if(String.valueOf(value).isEmpty() || String.valueOf(value).length() == 0) 
				return null;
			else 
				return Integer.parseInt(value.toString());			
		case "Short":
			return Short.parseShort(value.toString());
		case "String":
			return value.toString();
		default: //Char
			return value.toString();
		}
	}
	
	private void getClassTypeOrg(Field field, String clase, Integer id) throws IllegalArgumentException, IllegalAccessException {
		switch(clase) {
		case "Plantel":
			//GenericRepository<Plantel> plantel = new GenericRepository<>(new Plantel());
			//System.out.println(plantel.findByIdplantel(id));
			//field.set(this.objClass, plantel.findByIdplantel(id));
			break;
			default: break;
		}
	}
	
}
