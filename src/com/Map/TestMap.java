package com.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "apple");
		map.put("b", "banana");
		map.put("c", "cocole");
		map.put("d", "duang");
		String str = "a";
		String str1 = "a";
		if (str1.equals(str)) {
			Iterator<String> it = map.keySet().iterator();
			/*
			 * while (it.hasNext()) { String mapKey = it.next(); if ("c".equals(mapKey)) { continue; }
			 */
			String mapValue = map.get("c");
			System.out.println("map 的键：" + mapValue + "   map的值：" + mapValue);
			// }
		} else {

			System.out.println(">>>========");
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程start...");
				}
			}).start();
		}

	}

}
