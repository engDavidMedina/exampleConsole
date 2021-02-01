package com.ar.console.project.directories.interfaces;

import java.util.List;

import com.ar.console.project.directories.beans.DirectoryInformation;
import com.ar.console.project.menu.interfaces.SubMenu;

public interface IDirectoryInfomation extends SubMenu {
	
	/**
	 * Get the folder information of the given path
	 * @return some information of the given path
	 * @throws Exception
	 */
	public List<DirectoryInformation> getContentInformation(String path) throws Exception;
	
	/**
	 * Get the full path of the actual directory
	 * @return the path of the current directory
	 * @throws Exception
	 */
	public String getActualFullPath() throws Exception;
}
