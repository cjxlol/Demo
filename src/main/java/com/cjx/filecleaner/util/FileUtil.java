package com.cjx.filecleaner.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.nutz.resource.NutResource;
import org.nutz.resource.Scans;

public class FileUtil {
	private static Properties properties = new Properties();

	static {
		List<NutResource> resources = Scans.me().scan("src/main/resources/config/app.properties");
		try {
			properties.load(resources.get(0).getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getValue(String key) {
		return properties.getProperty(key);
	}

	public static void creatFiledir(File file) {
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public static File RandomFile(File file, int size) throws IOException {
		if (!file.exists()) {
			Random random = new Random();
			byte[] fileDataPut = new byte[size];
			random.nextBytes(fileDataPut);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(fileDataPut);
			fos.close();
		}
		return file;
	}
}
