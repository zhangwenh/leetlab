package io.rdk.leetlab.core.Heap.p215_kth_largest_element_in_an_array;

import java.util.PriorityQueue;

/**
 * 堆排序简化版
 */
class Solution2 {
    // Leetcode 215. Kth Largest Element in an Array
    // Heap
    // N is the size of nums
    // Time Complexity: O(NlogK)
    // Space Complexity: O(1)
    public int findKthLargest(int[] nums, int k) {
        // Min heap 默认从小到大排序
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if(q.size()>k){ // 进栈后，当有超过的立刻出栈
                q.poll();
            }
        }
        return q.peek();
    }
}
