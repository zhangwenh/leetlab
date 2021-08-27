package io.rdk.leetlab.normal.p1115_print_foobar_alternately;

import java.util.concurrent.Semaphore;

public class FooBar {
    private final int n;

    private final Semaphore fooSema = new Semaphore(1);
    private final Semaphore barSema = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSema.acquire();//值为1的时候，能拿到，执行下面的操作
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSema.release();//释放许可给barSema这个信号量 barSema 的值+1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSema.acquire();//值为1的时候，能拿到，执行下面的操作
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSema.release();//释放许可给fooSema这个信号量 fooSema 的值+1
        }
    }
}
