package com.webautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 * @author Kaushik Banerjee
 */

public class PropFileHandler {

	public static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties";
	public static String pageObjectFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\PageObjectRepository";
	static Properties property=new Properties();
	public static ResourceBundle rb;

	public static String getConfigProperty(String key){
		try{
			FileInputStream fis=new FileInputStream(filePath);
			property.load(fis);
			return property.getProperty(key);}
		catch(IOException e){
			System.out.print("Key not found within file");
			return null;
		}
	}
	
	public static ResourceBundle getPageObjectElements(String pageName){
		File file = new File(pageObjectFilePath);
		try{
		URL[] urls = {file.toURI().toURL()};
		ClassLoader loader = new URLClassLoader(urls);
		return ResourceBundle.getBundle(pageName,Locale.getDefault(),loader);
		}catch(MalformedURLException e){e.printStackTrace();
		return null;}
	}
}
