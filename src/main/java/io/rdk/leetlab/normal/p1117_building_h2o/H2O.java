package io.rdk.leetlab.normal.p1117_building_h2o;

import java.util.concurrent.Semaphore;

class H2O {

    private Semaphore hSema = new Semaphore(2);
    private Semaphore oSema = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hSema.acquire();
        releaseHydrogen.run();
        oSema.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oSema.acquire(2); // 一次申请2个，确保hydrogen()调用2次释放出2个osema后，才会走到本方法
        releaseOxygen.run();
        hSema.release(2);
    }
}
