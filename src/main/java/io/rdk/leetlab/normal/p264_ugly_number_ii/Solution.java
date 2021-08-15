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
        // 遍历n次，每次从最小堆中取出最小的数字
        // 然后和2,3,5相乘，再放回最小堆
        // 经过n次，从最小堆中取出最小的数字就是要的结果
        // 注意，这里有越界的问题
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        Set<Long> set = new HashSet<>();
        set.add(1L);
        int[] factors = new int[]{2,3,5};
        int res = 0;
        for (int i = 0; i < n; i++) { // 循环n次
            long curr = heap.poll(); // 取出最小的数字
            res = (int)curr;
            for(int factor:factors){
                long newInt = curr * factor;
                if(set.add(newInt)){
                    heap.add(newInt);
                }
            }
        }
        return res;
    }

    public int nthUglyNumber1(int n) {
        // 动态规划
        // dp:
        // 初始状态：dp[1] = 1
        // 方程式：min(dp[p2]*2,dp[p3]*3,dp[p5]*5)
        // 当前的p2,p3,p5三个指针，它们所指向的丑数再乘以其各自对应的因数（即2，3，5），
        // 所得到的三个乘数必定是大于当前数组的最大丑数的；
        // 三个指针对应位置的前一个位置（即p2-1,p3-1,p5-1），它们所指向的丑数乘以各自的因数，
        // 所得的三个乘数必定小于等于当前数组的最大丑数。WHY?
        // 很简单，因为这三个乘数都已经被放入数组中了，不然的话对应的指针是不会移动的；
        // 最终：dp[n]
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for(int i =2; i<=n; i++){
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2,num3), num5);
            // 这里注意下，不能用else if，因为存在着重复值！！
            if(dp[i] == num2){
                p2++;
            }
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
        }
        return dp[n];
    }

}
