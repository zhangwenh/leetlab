package io.rdk.leetlab.normal.p1114_print_in_order;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {
    private AtomicInteger fd = new AtomicInteger(0);
    private AtomicInteger sd = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        fd.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(fd.get() != 1){}
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        sd.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(sd.get() != 1){}
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
