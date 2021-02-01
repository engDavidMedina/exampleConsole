package com.ar.console.project.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ar.console.project.directories.beans.DirectoryInformation;
import com.ar.console.project.directories.impl.DirectoryInformationImpl;
import com.ar.console.project.directories.interfaces.IDirectoryInfomation;

public class DirectoryInformationTest {
	
	private static IDirectoryInfomation directoryInformation = new DirectoryInformationImpl();

	@Test
	public void currentDirectoryFullPathTestSuccess() {
		try {
			assertTrue("Ambas respuestas deben ser iguales", compareCurrentDirectory());
		} catch (Exception e) {
			fail();
		}
	}
	
	private Boolean compareCurrentDirectory() throws Exception {
		return directoryInformation.getActualFullPath().toString().equals(Paths.get("").toAbsolutePath().toString());
	}
	
	@Test
	public void currentDirectoryInformationTestSuccess() {
		try {
			assertTrue("Ambas respuestas deben ser iguales", compareInformationDirectory());
		} catch (Exception e) {
			fail();
		}
	}
	
	private Boolean compareInformationDirectory() throws Exception {
		List<DirectoryInformation> files = new ArrayList<DirectoryInformation>();
		Files.walk(Paths.get(".")).forEach(obj->{
			DirectoryInformation aux = new DirectoryInformation();
			aux.setIsDirectory(obj.toFile().isDirectory());
			aux.setName(obj.getFileName().toString());
			aux.setPath(obj.toAbsolutePath().toString());
			aux.setSize(String.valueOf(obj.toFile().getTotalSpace()));
			files.add(aux);
		});
		return directoryInformation.getContentInformation(".").toString().equals(files.toString());
	}

}
