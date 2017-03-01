package com.JVM;


public class Test {
	public static void main(String[] args) {

		/**
		 * 条件表达式
		 */
		Object o = true ? new Integer(1) : new Double(2.0);
		// System.out.println(o);

		for (int i = 0; i < 10; i++) {
			System.out.println((Integer) i);
			System.out.println();
		}

	}
	
	/**
	 * 
	 * Exception
	 * 
	 * @param e
	 */
	static void doThrow(Exception e) {
		Test.<RuntimeException> doThrow0(e);
	}

	@SuppressWarnings("unchecked")
	static <E extends Exception> void doThrow0(Exception e) throws E {
		throw (E) e;
	}
}
