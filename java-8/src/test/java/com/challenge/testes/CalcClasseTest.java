package com.challenge.testes;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.challenge.desafio.CalculadorDeClasses;

public class CalcClasseTest {
  
    @Before
    public void setUp() {
    }
    
    @Test
    public void somar() {
    	CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();
    	
    	Validar validar = new Validar();
    	
    	assertEquals(new BigDecimal(4l), calculadorDeClasses.somar(validar));
    }
    
    @Test
    public void subtrair() {
    	CalculadorDeClasses calculadorDeClasses = new CalculadorDeClasses();
    	
    	Validar validar = new Validar();
    	
    	assertEquals(new BigDecimal(8l), calculadorDeClasses.subtrair(validar));
    }
}