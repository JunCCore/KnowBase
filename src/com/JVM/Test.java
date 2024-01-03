package com.JVM;


public class Test {
    public static void main(String[] args) {

        /**
         * 条件表达式
         */
        Object o = (double) Integer.valueOf(1);
        // System.out.println(o);
        for (int i = 0; i < 10; i++) {
            System.out.println((Integer) i);
            System.out.println();
        }

    }

    /**
     *   @param e
     */
    static void doThrow(Exception e) {
        Test.doThrow0(e);
    }


    @SuppressWarnings("unchecked")
    static <E extends Exception> void doThrow0(Exception e) throws E {
        throw (E) e;
    }
}
