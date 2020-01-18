package 多线程;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2015-2020. All rights reserved.
 */

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2020年1月10日
 */
public class FizzBuzz {

    private int n;

    public AtomicInteger count = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (count.get() <= n) {
            int tmp = count.get();
            if (tmp <= n && tmp % 3 == 0 && tmp % 15 != 0) {
                printFizz.run();
                count.getAndIncrement();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (count.get() <= n) {
            int tmp = count.get();
            if (tmp <= n && tmp % 5 == 0 && tmp % 15 != 0) {
                printBuzz.run();
                count.getAndIncrement();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (count.get() <= n) {
            int tmp = count.get();
            if (tmp <= n && tmp % 15 == 0) {
                printFizzBuzz.run();
                count.getAndIncrement();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (count.get() <= n) {
            int tmp = count.get();
            if (tmp <= n && tmp % 3 != 0 && tmp % 5 != 0) {
                printNumber.accept(tmp);
                count.getAndIncrement();
            }
        }
    }

}
