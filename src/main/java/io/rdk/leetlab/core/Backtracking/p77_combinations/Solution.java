package io.rdk.leetlab.core.Backtracking.p77_combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        // 此题有个隐藏要求：[1,2][2,1]算一个解，不要重复反馈。
        List<List<Integer>> result = new ArrayList<>();
        // 此处用map也可以，但是考虑到隐藏要求，因此设置start
        backtracking(n,k,result,1,new ArrayList<>()); // 从1开始
        return result;
    }

    private void backtracking(int n, int k, List<List<Integer>> result, int start, ArrayList<Integer> list) {
        if(list.size()==k){ // 临时结果集合的长度等于k，则满足条件，退出
            result.add(new ArrayList<>(list)); // copy进去
        }else{
            for (int i = start; i <= n; i++) {
                list.add(i);
                backtracking(n,k,result,i+1,list);
                list.remove(list.size()-1); // remove list的最后一个元素，返回递归树形的上一级
            }
        }
    }


}
