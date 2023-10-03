package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

public class CommonFileUtils {
	
	
	public static String readPropertiesFile(String path, String key) throws IOException {
		File f = new File(path);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
	}
	/**
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public static String readUsermenuTestData(String key) throws IOException {
		File f = new File(FileConstants.USERMENU_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
		
	}
	public static String readOppertunityTestData(String key) throws IOException {
		File f = new File(FileConstants.OPPORTUNITY_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
		
	}
	public static String readLeadsTestData(String key) throws IOException {
		File f = new File(FileConstants.LEADS_TESTDATA_FILE_PATH);
		FileReader fr = new FileReader(f);
		Properties p = new Properties();
		p.load(fr);
		return p.getProperty(key);
		
		
	}

}
