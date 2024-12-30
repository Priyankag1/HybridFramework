package com.ots.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static String getproperty(String propertyName) {
		Properties pro=new Properties();
	
		try {
			pro.load(new FileInputStream(new File("./ConfigFiles/Config.properties")));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file"+e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File can not be loaded");
			
		}
		String value=pro.getProperty(propertyName);
		
		return value;
		
	
	/*public void readFile( ) throws IOException {
		File src=new File("./ConfigFiles/Config.properties");
		FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		System.out.println(pro.getProperty("appURLQA"));*/
		
		
		
	}
	public static String getProperty(String propertyFileName,String propertyName) {

		Properties pro = new Properties();

		try 
		{
		
			//get dynamic value of file name 
			pro.load(new FileInputStream(new File("./ConfigFiles/"+propertyFileName+".properties")));
			
			
		} catch (FileNotFoundException e) 
		{
			System.out.println("File not present "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Could not load the file");
		}

		String value=pro.getProperty(propertyName);
		
		return value;
	}

}
