package com.ar.console.project.directories.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.ar.console.project.directories.beans.DirectoryInformation;
import com.ar.console.project.directories.interfaces.IDirectoryInfomation;
import com.ar.console.project.menu.utils.InputOperations;
import com.ar.console.project.messages.MessagesEnum;

public class DirectoryInformationImpl implements IDirectoryInfomation {
	
	private static final String PATH_INPUT = "Ingrese el path del directorio a consultar";

	@Override
	public List<DirectoryInformation> getContentInformation(String path) throws Exception{
		List<DirectoryInformation> files = new ArrayList<DirectoryInformation>();
		Files.walk(Paths.get(path)).forEach(obj->{
			DirectoryInformation aux = new DirectoryInformation();
			aux.setIsDirectory(obj.toFile().isDirectory());
			aux.setName(obj.getFileName().toString());
			aux.setPath(obj.toAbsolutePath().toString());
			aux.setSize(String.valueOf(obj.toFile().getTotalSpace()));
			files.add(aux);
		});
		return files;
	}

	@Override
	public String getActualFullPath() throws Exception{
		return currentDirectory().toString();
	}
	
	/**
	 * Get current path
	 * @return the path of the current directory
	 */
	private static Path currentDirectory() {
		return Paths.get("").toAbsolutePath();
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
					String lineInput = showMessageAndGetInput(PATH_INPUT);
					System.out.println(getContentInformation(lineInput));
				} catch (Exception e) {
					System.err.println(MessagesEnum.UNRECOGNIZED_FORMAT_ERROR);
				}
				break;
			case 2:
				try {
					System.out.println(getActualFullPath());
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
	 * Show a message to the console and store the input
	 * @param message to show
	 * @return the input of the user
	 * @throws Exception
	 */
	private String showMessageAndGetInput(String message) throws Exception {
		System.out.println(message);
		return InputOperations.getStringOption();
	}
	
	/**
	 * Print the menu of the directory information option
	 */
	private static void printMenu() {
		System.out.println("***** Información del directorio *******");
		System.out.println("Para información sobre el contenido del directorio actual presione 1");
		System.out.println("Para mostrar el path completo del directorio actual presione 2");
		System.out.println("Para volver presione 0");
	}

}
