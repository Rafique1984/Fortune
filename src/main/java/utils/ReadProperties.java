package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadProperties {
	
	public  String getProperty(String key){
		
		String value = null;
		Properties prop = loadproperty("testRun");		
		value=prop.getProperty(key);
		if(value == null){
			String currentEnv = prop.getProperty("testEnv");
			prop = loadproperty(currentEnv);
			value=prop.getProperty(key);
			
		}
		
		return value;
	}
	public  String getSaucelabsProperties(String key){
		String  value = null;
		Properties prop = loadproperty("testRun");		
		value=prop.getProperty(key);
		
		return value;
	}

	private  Properties loadproperty(String propFilename){
		Properties prop = new Properties();
		
		String filepath = "./src/main/resources/properties/"+propFilename+".properties";
		try {
			File file = new File(filepath);
			FileInputStream stream = new FileInputStream(file);
			prop.load(stream);
		} catch (Exception e) {
						e.printStackTrace();
		}
		return prop;
	}

}
