package com.yang.test.ymkribbonconsumer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

/**
 * @author yangmingkai
 * @ClassName Test
 * @Description TODO
 * @date 2018/10/29 10:49 AM
 **/
public class Test implements Runnable {
    //静态变量，所有对象共享
    private static int count = 0;

    @Override
    public void run() {
        synchronized (Test.class) {
            for (int i = 0; i < 100; i++) {
                count();
            }
        }


    }

    public void count() {
        try {
            Thread.currentThread().sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws Exception {
        Test threadSafe1 = new Test();
        Test threadSafe2 = new Test();
        Thread thread1 = new Thread(threadSafe1);
        Thread thread2 = new Thread(threadSafe2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        Thread.currentThread().sleep(1000);
        System.out.println(count);

    }
}
