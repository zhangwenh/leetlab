package io.rdk.leetlab.core.Greedy.p1217_minimum_cost_to_move_chips_to_the_same_position;

public class Solution {
    // 奇数位置可以0代价在奇数位置反复横跳，偶数位置同理，
    // 最短不就是弄到相邻的两堆叠叠乐，
    // 把小堆扔到大堆就是最少代价
    // 其实就找到奇数位置的个数和偶数位置的个数
    public int minCostToMoveChips(int[] position) { // 注意：参数是位置
        //向偶数维移动需要的次数
        int countOdd = 0;
        //向奇数位移动需要的次数
        int countEven = 0;
        for (int j : position) {
            if (j % 2 == 1) {
                countOdd++;
            } else {
                countEven++;
            }
        }
        return Math.min(countOdd, countEven);
    }
}

