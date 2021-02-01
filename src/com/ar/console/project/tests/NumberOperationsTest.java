package com.ar.console.project.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.ar.console.project.numbers.impl.NumberOperationsImpl;
import com.ar.console.project.numbers.interfaces.INumbersOperations;

public class NumberOperationsTest {
	
	private static INumbersOperations numbersOperations = new NumberOperationsImpl();

	private static List<Integer> array2Numbers = Arrays.asList(5, 2);
	
	private static List<Integer> array3Numbers = Arrays.asList(4, 2, 3);
	
	@Test
	public void sum2NumbersTestSuccess() {
		try {
			assertTrue("La suma debe ser 7", numbersOperations.sumNumbers(array2Numbers).equals(7));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void sum3NumbersTestSuccess() {
		try {
			assertTrue("La suma debe ser 9", numbersOperations.sumNumbers(array3Numbers).equals(9));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void sub2NumbersTestSuccess() {
		try {
			assertTrue("La resta debe ser 3", numbersOperations.substractNumbers(array2Numbers).equals(3));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void sub3NumbersTestSuccess() {
		try {
			assertTrue("La resta debe ser -1", numbersOperations.substractNumbers(array3Numbers).equals(-1));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void multiply2NumbersTestSuccess() {
		try {
			assertTrue("La multiplicación debe ser 10", numbersOperations.multiplyNumbers(array2Numbers).equals(BigDecimal.valueOf(10)));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void multiply3NumbersTestSuccess() {
		try {
			assertTrue("La multiplicación debe ser 24", numbersOperations.multiplyNumbers(array3Numbers).equals(BigDecimal.valueOf(24)));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void division2NumbersTestSuccess() {
		try {
			assertTrue("La división debe ser 2.50", numbersOperations.divideNumbers(array2Numbers).toString().equals("2.50"));
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void division3NumbersTestSuccess() {
		try {
			assertTrue("La división debe ser 0.67", numbersOperations.divideNumbers(array3Numbers).toString().equals("0.67"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void fibonacciTestSuccess() {
		try {
			assertTrue("El fibonacci de 5 debe ser 5", numbersOperations.getFibonacci(5).toString().equals("5"));
			assertTrue("El fibonacci de 8 debe ser 21", numbersOperations.getFibonacci(8).toString().equals("21"));
			assertTrue("El fibonacci de 10 debe ser 55", numbersOperations.getFibonacci(10).toString().equals("55"));
		} catch (Exception e) {
			fail();
		}
	}
}
