package io.rdk.leetlab.normal.p57_insert_interval;

import java.util.ArrayList;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> resList = new ArrayList<>();
        int index = 0;
        int len = intervals.length;
        // 把左边不需要合并的元素都放进resList
        while(index < len && intervals[index][1] < newInterval[0]){
            resList.add(intervals[index]);
            index++;
        }
        // 把需要合并的元素进行合并后放进resList
        // 可能存在3种情况，均为intervals[][0] <= newInterval[1]
        while(index < len && intervals[index][0] <= newInterval[1]){
            // 判断start
            newInterval[0] = Math.min(intervals[index][0],newInterval[0]);
            // 判断end
            newInterval[1] = Math.max(intervals[index][1],newInterval[1]);
            index++;
        }
        // 遍历完所有可能合并的场景后再放入
        resList.add(newInterval);
        // 把右边不需要合并的元素都放进resList
        while(index < len && intervals[index][0] > newInterval[1]){
            resList.add(intervals[index]);
            index++;
        }
        return resList.toArray(new int[0][]);
    }
}
