package com.ar.console.project.menu;

import com.ar.console.project.directories.impl.DirectoryInformationImpl;
import com.ar.console.project.directories.interfaces.IDirectoryInfomation;
import com.ar.console.project.menu.utils.InputOperations;
import com.ar.console.project.messages.MessagesEnum;
import com.ar.console.project.numbers.impl.NumberOperationsImpl;
import com.ar.console.project.numbers.interfaces.INumbersOperations;

public class PrincipalMenu {
	
	private static IDirectoryInfomation directoryInformation = new DirectoryInformationImpl();
	
	private static INumbersOperations numbersOperations = new NumberOperationsImpl();

	/**
	 * Print the main menu and deliver to the submenu
	 */
	public static void Menu() { 
		printMenu();
		Integer command = InputOperations.getIntegerOption();
		while(!command.equals(0)) {
			switch (command) {
			case 0:
				return;
			case 1:
				directoryInformation.printSubMenu();
				break;
			case 2:
				numbersOperations.printSubMenu();
				break;
			default:
				System.err.println(MessagesEnum.UNRECOGNIZED_COMMAND_ERROR);
				break;
			}
			printMenu();
			command = InputOperations.getIntegerOption();
		}
	}
	
	private static void printMenu() {
		System.out.println("***** Menu *******");
		System.out.println("Para información sobre directorios presione 1");
		System.out.println("Para operaciones con números presione 2");
		System.out.println("Para salir presione 0");
	}
}
