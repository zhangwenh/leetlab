package io.rdk.leetlab.core.Queue.p622_design_circular_queue;

import java.util.Deque;
import java.util.LinkedList;

class MyCircularQueue {
    Deque<Integer> deque=new LinkedList<>();
    int l;
    public MyCircularQueue(int k) {
        this.l=k;
    }

    public boolean enQueue(int value) {
        if(deque.size() < l){
            deque.add(value);
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(deque.size()>0){
            deque.pollFirst();
            return true;
        }
        return false;
    }

    public int Front() {
        if(deque.size()>0){
            return deque.getFirst();
        }
        return -1;
    }

    public int Rear() {
        if(deque.size()>0){
            return deque.getLast();
        }
        return -1;
    }

    public boolean isEmpty() {
        return deque.size() <= 0;
    }

    public boolean isFull() {
        return deque.size() == l;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
