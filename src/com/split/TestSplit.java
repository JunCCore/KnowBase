package com.split;

import java.util.ArrayList;
import java.util.List;

public class TestSplit {
	
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		List<String> infolist = new ArrayList<String>();
		infolist.add("zhang");
		infolist.add("23");

		for (String strInfo : infolist) {
			String[] info = strInfo.split(" ");
			Person p = new Person();
			p.setName(info[0]);
			p.setAddress(info[1]);
			// p.setAddress(info[3]);
			// p.setSex(info[4]);

			persons.add(p);
		}
		System.out.println(persons);
	}
}
