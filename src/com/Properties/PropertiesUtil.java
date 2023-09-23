package com.Properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private final static String filePath = "KnowBase" + File.separator + "WEB-INF" + File.separator + "conf" + File.separator;

	// 获取属性文件值更新
	public static String getPropertiesValue(String fileName, String Key, String defaultValue) {
		String file = filePath + fileName;
		Properties properties = PropertiesUtil.readProperties(file);
		return properties.getProperty(Key, defaultValue);
	}

	private static Properties readProperties(String fileName) {
		Properties props = new Properties();
		InputStream in = null;

		try {
			in = new BufferedInputStream(new FileInputStream(new File(fileName)));
			props.load(in);
			System.out.println(fileName + "has been loaded");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fileName + "is not found");
		} catch (IOException ioe) {
			System.err.println(fileName + "is failed");
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ioe) {
				System.out.println(fileName + "can not be closed");
			}
		}
		return props;
	}
}
