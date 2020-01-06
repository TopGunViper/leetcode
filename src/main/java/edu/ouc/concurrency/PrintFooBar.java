package edu.ouc.concurrency;

import java.util.concurrent.Semaphore;

public class PrintFooBar {
    private int n;
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);

    public PrintFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            s1.release();
            s2.acquire();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            s1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            s2.release();
        }
    }

    public static void main(String[] args) throws Exception {
        int n = 10;
        PrintFooBar printFooBar = new PrintFooBar(n);
        Thread t1 = new Thread(() -> {
            try {
                printFooBar.foo(() -> System.out.println("foo"));
            } catch (Exception e) {
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                printFooBar.bar(() -> System.out.println("bar"));
            } catch (Exception e) {
            }
        });
        t2.start();

        t1.join();
        t2.join();
    }
}
