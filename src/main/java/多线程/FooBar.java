package 多线程;

import java.util.concurrent.Semaphore;

public class FooBar {

    private int n;

    private final Semaphore fooPrinted = new Semaphore(0);

    private final Semaphore barPrinted = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                barPrinted.acquire();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooPrinted.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            fooPrinted.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            barPrinted.release();
        }
    }
}
