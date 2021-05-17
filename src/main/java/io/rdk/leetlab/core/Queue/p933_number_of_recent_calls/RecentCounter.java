package io.rdk.leetlab.core.Queue.p933_number_of_recent_calls;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<Integer>();
    }

    public int ping(int t) {
        q.add(t);
        while (!q.isEmpty() && q.peek() < t-3000)
            q.poll();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
