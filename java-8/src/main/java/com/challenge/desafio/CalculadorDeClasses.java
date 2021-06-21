package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel{

	@Override
	public BigDecimal somar(Object obj) {
		BigDecimal result = BigDecimal.ZERO;
		
		Class clazz = obj.getClass();

		for (Field atributo : clazz.getDeclaredFields()) {
			if (atributo.isAnnotationPresent(Somar.class) && atributo.getType().getName().equals(BigDecimal.class.getName())) {
				atributo.setAccessible(true);
				try {
					result = result.add( (BigDecimal) atributo.get(obj));
				} catch(IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public BigDecimal subtrair(Object obj) {
		BigDecimal result = BigDecimal.ZERO;
		
		Class clazz = obj.getClass();

		for (Field atributo : clazz.getDeclaredFields()) {
			if (atributo.isAnnotationPresent(Subtrair.class) && atributo.getType().getName().equals(BigDecimal.class.getName())) {
				atributo.setAccessible(true);
				try {
					result = result.add( (BigDecimal) atributo.get(obj));
					
				} catch(IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	@Override
	public BigDecimal totalizar(Object obj) {
		return this.somar(obj).subtract(this.subtrair(obj));
	}

}
