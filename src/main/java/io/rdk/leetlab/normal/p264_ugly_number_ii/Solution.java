package io.rdk.leetlab.normal.p264_ugly_number_ii;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    // 丑数。。。x2 x3 x5
    // 1,2,3,4,5,6,8,9,10,12,15...

    public int nthUglyNumber(int n) {
        // 最小堆
        // 利用最小堆解决排序的问题
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int[] factors = new int[]{2,3,5};
        for (int i = 0; i < n; i++) { // 循环n次

        }
        return 0;
    }

    public int nthUglyNumber1(int n) {
        // 动态规划
        return 0;
    }

}
