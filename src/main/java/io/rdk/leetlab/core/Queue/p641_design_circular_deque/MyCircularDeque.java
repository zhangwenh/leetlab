package io.rdk.leetlab.core.Queue.p641_design_circular_deque;

import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque {

    Deque<Integer> q;
    int len;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        q = new LinkedList<>();
        len = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(q.size()<len){
            q.addFirst(value);
            return true;
        }else{
            return false;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(q.size()<len){
            q.addLast(value);
            return true;
        }else{
            return false;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(q.isEmpty()){
            return false;
        }else{
            q.removeFirst();
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(q.isEmpty()){
            return false;
        }else{
            q.removeLast();
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(q.isEmpty()){
            return -1;
        }else{
            return q.getFirst();
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(q.isEmpty()){
            return -1;
        }else{
            return q.getLast();
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return q.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return q.size() == len;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
