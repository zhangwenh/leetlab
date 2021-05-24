package io.rdk.leetlab.core.Backtracking.p78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 暴力法
 */
public class Solution {

    // 原理是：轮询每个元素，加到之前的结果集里
    // 例如[1,2,3]：
    // [],
    // [1],
    // [2],[1,2], -- 2加到[]里形成[2]，加到[1]里形成[1,2]
    // [3],[1,3],[1,2,3]
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // [[...]...]
        result.add(new ArrayList<>()); // 空值

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>(); // 要循环result，因此这里需要增加一个临时listß
            for (List<Integer> subList : result) {
                List<Integer> newSubset = new ArrayList<>(subList); //复制结果中已经存在的子集
                newSubset.add(num);
                newSubsets.add(newSubset);
            }
            result.addAll(newSubsets);
        }

        return result;
    }

}
