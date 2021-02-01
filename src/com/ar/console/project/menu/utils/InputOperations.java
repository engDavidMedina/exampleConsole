package com.ar.console.project.menu.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputOperations {
	
	private static BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * Reads the option
	 * @return the option in the input or -1 if an error occurred
	 */
	public static Integer getIntegerOption() {
		try {
			return Integer.valueOf(buffReader.readLine().trim());
		} catch (Exception e) {
			return -1;
		}
	}
	
	/**
	 * Reads the option
	 * @return the option in the input or empty if an error occurred
	 */
	public static String getStringOption() {
		try {
			return buffReader.readLine().trim();
		} catch (Exception e) {
			return "";
		}
	}
}
