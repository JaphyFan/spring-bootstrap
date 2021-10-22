package com.japhy.basic.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2020/11/4 16:30
 */
public class SynchroDemo {


    static class AtomAdd {

        private static final Object OBJECT = new Object();

        private static int index = 0;

        public void atomAdd() {
            synchronized (OBJECT) {
                try {
                    TimeUnit.MINUTES.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                index++;
                System.out.println(index);
            }
        }
    }


    public static void main(String[] args) {
        AtomAdd atomAdd = new AtomAdd();
        for (int i = 0; i < 5; i++) {
            new Thread(atomAdd::atomAdd).start();
        }
    }

}
