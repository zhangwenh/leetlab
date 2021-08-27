package io.rdk.leetlab.normal.p1116_print_zero_even_odd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    Semaphore semaZero = new Semaphore(1); // 0
    Semaphore semaOdd = new Semaphore(0); // odd
    Semaphore semaEven = new Semaphore(0); // even

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++){
            semaZero.acquire();
            printNumber.accept(0);
            if((i & 1) == 1){ // 奇数
                semaOdd.release();
            }else{
                semaEven.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0) {//偶数 打印偶数 并释放zero的线程
                semaEven.acquire();
                printNumber.accept(i);
                semaZero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 1) {//奇数，打印奇数，并释放zero的线程
                semaOdd.acquire();
                printNumber.accept(i);
                semaZero.release();
            }
        }
    }
}
