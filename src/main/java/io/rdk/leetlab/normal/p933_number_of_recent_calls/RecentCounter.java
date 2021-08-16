package io.rdk.leetlab.normal.p933_number_of_recent_calls;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        while(!q.isEmpty() && t > q.peek()+3000)
            q.poll();
        return q.size();
    }
}
