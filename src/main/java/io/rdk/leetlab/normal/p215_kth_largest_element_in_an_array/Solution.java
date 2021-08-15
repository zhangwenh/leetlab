package io.rdk.leetlab.normal.p215_kth_largest_element_in_an_array;

import java.util.Arrays;
import java.util.PriorityQueue;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 排序法
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest1(int[] nums, int k) {
        // 堆排序
        // 将每个元素加到最小堆中去
        // 去掉前k-1个值，得到第k大的值
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if(q.size()>k){ // 当有超过的立刻出栈
                q.poll();
            }
        }
        return q.peek();
    }

    // 还有一种快速排序法
}
