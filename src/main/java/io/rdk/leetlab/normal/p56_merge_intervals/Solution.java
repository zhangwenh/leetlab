package io.rdk.leetlab.normal.p56_merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> resList = new ArrayList<>();
        // 对开始字段进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 取出排序后的结果，每个与resList进行比较
        for (int[] interval : intervals) {
            int lastIndex = resList.size() - 1;
            // resList为空，或者interval开始大于已有的结束
            // 那么直接把interval放进去
            if(lastIndex == -1 || interval[0] > resList.get(lastIndex)[1]){
                resList.add(interval);
            }else{
                // 否则说明有合并
                // 则把最后一个的结束调整为max(lastIndex[1],interval[1])
                resList.get(lastIndex)[1] = Math.max(resList.get(lastIndex)[1], interval[1]);
            }
        }
        return resList.toArray(new int[resList.size()][2]);
    }
}
