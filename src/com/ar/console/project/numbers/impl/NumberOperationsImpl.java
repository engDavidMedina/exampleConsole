package com.ar.console.project.numbers.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ar.console.project.menu.utils.InputOperations;
import com.ar.console.project.messages.MessagesEnum;
import com.ar.console.project.numbers.interfaces.INumbersOperations;

public class NumberOperationsImpl implements INumbersOperations {
	
	private static final String SUM_MESSAGE = "Ingrese los números a sumar separados por espacios (solo enteros)";
	private static final String SUBSTRACT_MESSAGE = "Ingrese los números a restar separados por espacios (solo enteros)";
	private static final String MULTIPLY_MESSAGE = "Ingrese los números a multiplicar separados por espacios (solo enteros)";
	private static final String DIVIDE_MESSAGE = "Ingrese los números a dividir separados por espacios (solo enteros)";
	private static final String FIBONACCI_MESSAGE = "Ingrese el número (entero) para calcular el fibonacci (entre 0 y 40)";

	@Override
	public Integer sumNumbers(List<Integer> numbers)  throws Exception{
		return numbers.stream().mapToInt(Integer::intValue).sum();
	}

	@Override
	public Integer substractNumbers(List<Integer> numbers)  throws Exception{
		Integer total = numbers.get(0);
		for (Integer element : numbers.subList(1, numbers.size())) {
			total -= element;
		}
		return total;
	}

	@Override
	public BigDecimal multiplyNumbers(List<Integer> numbers)  throws Exception{
		BigDecimal total = BigDecimal.valueOf(numbers.get(0));
		for (Integer element : numbers.subList(1, numbers.size())) {
			total = total.multiply(BigDecimal.valueOf(element));
		}
		return total;
	}

	@Override
	public BigDecimal divideNumbers(List<Integer> numbers)  throws Exception{
		BigDecimal total = BigDecimal.valueOf(numbers.get(0));
		for(Integer element : numbers.subList(1, numbers.size())) {
			total = total.divide(BigDecimal.valueOf(element), 2, RoundingMode.HALF_UP);
		}
		return total;
	}

	@Override
	public BigDecimal getFibonacci(Integer number) throws Exception {
		return calculateFibonacci(number);
	}
	
	private BigDecimal calculateFibonacci(int n) {
		if(n <= 1) {
			return BigDecimal.valueOf(n);
		}
		return calculateFibonacci(n-1).add(calculateFibonacci(n-2));
	}
	
	@Override
	public void printSubMenu() {
		printMenu();
		Integer option = InputOperations.getIntegerOption();
		while(!option.equals(0)) {
			switch (option) {
			case 0:
				return;
			case 1:
				try {
					List<Integer> numbers = showMessageAndGetIntegers(SUM_MESSAGE);
					System.out.println("La suma: " + sumNumbers(numbers));
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			case 2:
				try {
					List<Integer> numbers = showMessageAndGetIntegers(SUBSTRACT_MESSAGE);
					System.out.println("La resta: " + substractNumbers(numbers));
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			case 3:
				try {
					List<Integer> numbers = showMessageAndGetIntegers(MULTIPLY_MESSAGE);
					try {
						System.out.println("La multiplicación: " + multiplyNumbers(numbers));
					} catch (Exception e) {
						System.err.println(MessagesEnum.SYSTEM_ERROR);
					}
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			case 4:
				try {
					List<Integer> numbers = showMessageAndGetIntegers(DIVIDE_MESSAGE);
					try {
						System.out.println("La division: " + divideNumbers(numbers));
					} catch (Exception e) {
						if(e instanceof ArithmeticException) {
							System.err.println(MessagesEnum.DIVIDE_BY_ZERO_ERROR);
						} else {
							System.err.println(MessagesEnum.SYSTEM_ERROR);
						}
						
					}
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			case 5:
				try {
					Integer number = showMessageAndGetInteger(FIBONACCI_MESSAGE);
					if(number < 0 || number > 40) {
						throw new Exception();
					}
					try {
						System.out.println("El fibonacci para: "+ number + " es: " + getFibonacci(number));
					} catch (Exception e) {
						System.err.println(MessagesEnum.SYSTEM_ERROR);
					}
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			default:
				System.err.println(MessagesEnum.UNRECOGNIZED_COMMAND_ERROR);
				break;
			}
			printMenu();
			option = InputOperations.getIntegerOption();
		}
	}
	
	/**
	 * Shows message and store the input
	 * @param message to show
	 * @return the input in a list of integers
	 * @throws Exception
	 */
	private List<Integer> showMessageAndGetIntegers(String message) throws Exception {
		System.out.println(message);
		String line = InputOperations.getStringOption();
		List<Integer> numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		if(numbers.size()>=2) {
			return numbers;
		} else {
			throw new Exception(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR.toString());
		}
	}
	
	/**
	 * Shows message and store the input
	 * @param message to show
	 * @return the integer of the input
	 * @throws Exception
	 */
	private Integer showMessageAndGetInteger(String message) throws Exception {
		System.out.println(message);
		Integer number = InputOperations.getIntegerOption();
		if(number == -1) {
			throw new Exception(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR.toString());
		} else {
			return number;
		}
	}

	/**
	 * Print the menu of the numbers operations option
	 */
	private static void printMenu() {
		System.out.println("***** Operaciones con números *******");
		System.out.println("Para sumar presione 1");
		System.out.println("Para restar presione 2");
		System.out.println("Para multiplicar presione 3");
		System.out.println("Para dividir presione 4");
		System.out.println("Para imprimir el fibonacci presione 5");
		System.out.println("Para volver presione 0");
	}
}
