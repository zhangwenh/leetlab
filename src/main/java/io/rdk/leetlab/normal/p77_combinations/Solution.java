package io.rdk.leetlab.normal.p77_combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> resList = new ArrayList<>();
        // 注意：这里也用hashmap来记录每个元素的访问情况，但是效率没直接start来得好
        backtracking(resList,n,k,new ArrayList<>(),1);
        return resList;
    }

    /**
     *
     * @param resList 最终结果
     * @param n n
     * @param k k
     * @param tempList 存放临时结果的list
     * @param start 开始的元素（数字）
     */
    private void backtracking(List<List<Integer>> resList, int n, int k, List<Integer> tempList, int start) {
        if(tempList.size() == k){
            resList.add(new ArrayList<>(tempList));
            return; // return效率比下面跟else高
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            // 注意：这里是i+1，而不是start+1
            backtracking(resList, n, k, tempList, i+1);
            // 放完要回归
            tempList.remove(tempList.size()-1);
        }
    }
}
