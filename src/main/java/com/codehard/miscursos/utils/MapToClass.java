package com.codehard.miscursos.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.codehard.miscursos.modelos.Plantel;
import com.codehard.miscursos.services.PlantelServiceImp;

public class MapToClass<T> {

	private T objClass;
	private Map<String, Object> mapa;
	private Map<Object, Object[]> lstIdesExternos;
	private String packages;

	public MapToClass(T clase) {
		this.objClass = clase;
	}

	public void setConfiguration(Map<String, Object> mapa, String packages) {

		this.lstIdesExternos = new HashMap<>();
		this.mapa = mapa;
		this.packages = packages;
	}

	public void getTogas() {
		lstIdesExternos.forEach((nombreclase, idnombre) -> {
			Class<? extends Object> clase = objClass.getClass();
			try {
				Field field = clase.getDeclaredField(idnombre[0].toString());
				field.setAccessible(true);
				Integer id = Integer.parseInt(idnombre[1].toString());
				getClassTypeOrg(field, nombreclase.toString(), id);
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}

	public T getClassMap() {
		mapa.forEach((k, v) -> {
			Class<? extends Object> clase = objClass.getClass();
			Field[] fields = clase.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				if (field.getName().equals(k)) {
					if (isClassOther(field)) {
						try {
							field.set(this.objClass, getTypeAction(field, v));
						} catch (IllegalArgumentException | IllegalAccessException e) {
							e.printStackTrace();
						}
					} else {
						lstIdesExternos.put(field.getType().getSimpleName(),
								new Object[] { k, getTypeAction(field, v) }); // Clase, [idnombre, valorid]
					}
				}
			}
		});

		getTogas();
		return this.objClass;
	}

	private boolean isClassOther(Field field) {
		return field.getType().getName().contains(this.packages) ? false : true;
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
			if (String.valueOf(value).isEmpty() || String.valueOf(value).length() == 0)
				return null;
			else
				return Integer.parseInt(value.toString());
		case "Short":
			return Short.parseShort(value.toString());
		case "String":
			return value.toString();
		default: // Char
			return value.toString();
		}
	}

	private void getClassTypeOrg(Field field, String clase, Integer id)
			throws IllegalArgumentException, IllegalAccessException {
		switch (clase) {
		case "Plantel":
			//GetInAllRepo<Plantel> plantel = new GetInAllRepo<>();
			field.set(this.objClass, plantelServiceImp.getPlantelById(id) );
			break;
		default:
			break;
		}
	}
	
	@Autowired
	@Qualifier("servicioPlantel")
	private PlantelServiceImp plantelServiceImp;
}
