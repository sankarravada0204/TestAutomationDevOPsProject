package com.au.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	Properties prop;
	public ConfigReader() {
		try {
			FileInputStream file = new FileInputStream("");
			prop = new Properties();
			prop.load(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getConfigDataValue(String key) {
		return prop.getProperty(key);
	}

}
