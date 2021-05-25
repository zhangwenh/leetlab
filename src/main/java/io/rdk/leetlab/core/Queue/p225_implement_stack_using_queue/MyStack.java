package io.rdk.leetlab.core.Queue.p225_implement_stack_using_queue;

import java.util.Deque;
import java.util.LinkedList;

class MyStack {

    Deque<Integer> q1,q2;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);//先将要插入的元素加入到辅助队列中，确保这个数据在队顶
        while(!q1.isEmpty()){
            q2.add(q1.poll());// 把q1的数据都放到q2
        }
        //交换
        Deque<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(q1==null || q1.isEmpty()){return -1;}else{return q1.poll();}
    }

    /** Get the top element. */
    public int top() {
        if(q1==null || q1.isEmpty()){return -1;}else{return q1.peek();}
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
