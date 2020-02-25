package 多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class 按序打印1114 {

    public static void main(String[] args) {

    }

}

class Foo {

    private static final Lock lock = new ReentrantLock();

    private Condition onePrinted = lock.newCondition();

    private boolean firstFinished = false;

    private Condition twoPrinted = lock.newCondition();

    private boolean secondFinished = false;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            printFirst.run();
            firstFinished = true;
            onePrinted.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (!firstFinished) {
                onePrinted.await();
            }
            printSecond.run();
            secondFinished = true;
            twoPrinted.signal();
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (!secondFinished) {
                twoPrinted.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }
}
