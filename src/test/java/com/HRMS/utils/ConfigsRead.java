package com.HRMS.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsRead {
	public static Properties prop;
	
	public static void readProperty(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
