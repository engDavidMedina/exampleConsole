package com.ar.console.project.numbers.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.ar.console.project.menu.interfaces.SubMenu;

public interface INumbersOperations extends SubMenu {
	
	/**
	 * Sum the given numbers
	 * @param numbers to be sum
	 * @return the sum of the numbers
	 * @throws Exception
	 */
	public Integer sumNumbers(List<Integer> numbers) throws Exception;
	
	/**
	 * Substract the given numbers
	 * @param numbers to be substract
	 * @return the substract of the numbers
	 * @throws Exception
	 */
	public Integer substractNumbers(List<Integer> numbers) throws Exception;
	
	/**
	 * Multiply the given numbers
	 * @param numbers to be multiply
	 * @return the result of the multiplication
	 * @throws Exception
	 */
	public BigDecimal multiplyNumbers(List<Integer> numbers) throws Exception;
	
	/**
	 * Divide the given numbers
	 * @param numbers
	 * @return the result of the division
	 * @throws Exception
	 */
	public BigDecimal divideNumbers(List<Integer> numbers) throws Exception;
	
	/**
	 * Calculate the fibonacci sequence for the given number
	 * @param number of the iterations for the fibonacci sequence
	 * @return the fibonacci of the given number
	 * @throws Exception
	 */
	public BigDecimal getFibonacci(Integer number) throws Exception;
}
