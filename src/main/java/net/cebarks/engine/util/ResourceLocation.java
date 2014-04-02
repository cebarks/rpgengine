package net.cebarks.engine.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceLocation {

	private File path;

	public ResourceLocation(String path) {
		this.path = new File(path);
	}

	public InputStream getResourceAsStream(String location) {
		File resource = getResource(location);
		InputStream inputStream = null;
		
		if(resource==null) {
			return null;
		}
		try {
			inputStream =  new FileInputStream(getResource(location));
		} catch (FileNotFoundException e) {
			
		} 
		return inputStream;
	}

	public File getResource(String location) {
		File file = new File(path, location);
		if(!file.exists()) {
			return null;
		}
		return file;
	}
}
