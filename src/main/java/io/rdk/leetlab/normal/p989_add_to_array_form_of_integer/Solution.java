package io.rdk.leetlab.normal.p989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 暴力法
        // 这个方法不可用，会溢出
        List<Integer> res = new ArrayList<>();
        double numSum = 0;
        for(int i = 0; i < num.length; i++){
            numSum += Math.pow(10,num.length-i-1) * num[i];
        }
        numSum += k;
        String numStr = Double.toString(numSum);
        for(char c : numStr.toCharArray()){
            res.add(Integer.parseInt(String.valueOf(c)));// 注意：这里不能直接(int)c，会变为ascii
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3};
        int k = 516;
        List<Integer> res = solution.addToArrayForm(nums,k);
        System.out.println(res.toString());
    }
}
