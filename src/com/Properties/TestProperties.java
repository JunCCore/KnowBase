package com.Properties;


public class TestProperties {
	public static void main(String[] args) {

		String pro = PropertiesUtil.getPropertiesValue("testt", "display", "");
		System.out.println("propreties:" + pro);

	}
}
