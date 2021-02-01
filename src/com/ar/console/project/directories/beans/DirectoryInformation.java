package com.ar.console.project.directories.beans;

import java.io.Serializable;

public class DirectoryInformation implements Serializable {

	private static final long serialVersionUID = -5121336960290336847L;
	
	/*
	 * Name of the resource
	 */
	private String name;
	/*
	 * Size of the resource
	 */
	private String size;
	/*
	 * Path of the resource
	 */
	private String path;
	/*
	 * Flag is a directory
	 */
	private Boolean isDirectory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Boolean getIsDirectory() {
		return isDirectory;
	}
	public void setIsDirectory(Boolean isDirectory) {
		this.isDirectory = isDirectory;
	}
	@Override
	public String toString() {
		return "DirectoryInformation [name=" + name + ", size=" + size + ", path=" + path + ", isDirectory="
				+ isDirectory + "]";
	}
}
