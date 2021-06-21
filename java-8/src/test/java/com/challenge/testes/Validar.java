package com.challenge.testes;

import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

public class Validar {
	
	@Somar
	BigDecimal num1 = new BigDecimal(2l);
	@Somar
	BigDecimal num2 = new BigDecimal(2l);
	
	@Subtrair
	BigDecimal num3 = new BigDecimal(3l);
	@Subtrair
	BigDecimal num4 = new BigDecimal(5l);
	
}
