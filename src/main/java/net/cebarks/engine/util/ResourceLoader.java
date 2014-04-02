package net.cebarks.engine.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class ResourceLoader {

	private static ArrayList<ResourceLocation> locations = new ArrayList<ResourceLocation>();

	public static InputStream getResourceAsStream(String location) {
		InputStream in = null;

		InputStream in2;
		try {
			in2 = new FileInputStream(getResource(location));
			if (in2 != null)
				in = in2;
		} catch (FileNotFoundException e) {

		}

		return in;
	}

	public static File getResource(String location) {
		File file = null;
		for (ResourceLocation resourceLocation : locations) {
			File file2 = resourceLocation.getResource(location);
			if (file2 != null) {
				file = file2;
				break;
			}
		}
		return file;
	}
}
