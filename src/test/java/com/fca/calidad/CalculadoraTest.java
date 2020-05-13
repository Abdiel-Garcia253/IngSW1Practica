package com.fca.calidad;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculadoraTest {
	private Calculadora miCalculadora ;
	
	@Before
	public void setup(){
		 miCalculadora = new Calculadora();
	}

	@Test
	public void sumaPositivosTest() {
		//Llamar al código
		float resultadoEsperado = 6;
		float resultadoEjecucion = miCalculadora.suma(2, 4);
		//Verificar
		assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
	}
	
	@Test
	public void sumaConCeroTest() {
		//Llamar al código
		float resultadoEsperado = 4;
		float resultadoEjecucion = miCalculadora.suma(0,4);
	
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	@Test
	public void multiplicaCeroTest() {
		//Llamar al código
		float resultadoEsperado = 0;
		float resultadoEjecucion = miCalculadora.multiplica(0,2);
		//Verificar
		assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
		
	}
	
	@Test
	public void multiplicaDosNumTest() {
		//Llamar al código
		float resultadoEsperado = 4;
		float resultadoEjecucion = miCalculadora.multiplica(2,2);
	
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	@Test(expected = ArithmeticException.class)
	public void divideCeroTest() {
		//Llamar al código
		
		float resultadoEjecucion = miCalculadora.divide(5,0);
		//Verificar
		System.out.println("Ejecutando división entre cero!");
	}
	
	@Test
	public void divideIgualesTest() {
		//Llamar al código
		float resultadoEsperado = 1;
		float resultadoEjecucion = miCalculadora.divide(5,5);
	
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	
	@After
	public void tearDown(){
		System.out.println("Prueba terminada!");
	}

}