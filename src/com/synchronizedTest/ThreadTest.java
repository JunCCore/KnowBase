package com.synchronizedTest;



    public class ThreadTest implements Runnable {

        public void run() {
            synchronized (this) {
                for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + "  Synconized loop" + i);
                }
            }

        }



    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ThreadTest t1 = new ThreadTest();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}

