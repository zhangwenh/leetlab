package io.rdk.leetlab.normal.p1114_print_in_order;

public class Foo1 {

    private boolean fd = false;
    private boolean sd = false;
    private final Object lock = new Object();

    public Foo1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock){
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            fd = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock){
            while(!fd){ // 必须要用while，而不是if
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sd = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!sd) { // 必须要用while，而不是if
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
