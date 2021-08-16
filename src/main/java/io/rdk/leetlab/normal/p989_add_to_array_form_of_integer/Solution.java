package io.rdk.leetlab.normal.p989_add_to_array_form_of_integer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] nums, int k) {
        // 暴力法
        // 这个方法不可用，会溢出
        List<Integer> res = new ArrayList<>();
        long numSum = 0;
        for(int i = 0; i < nums.length; i++){
            numSum += Math.pow(10,nums.length-i-1) * nums[i]; // 会溢出变为负数
        }
        numSum += k;
        String numStr = Long.toString(numSum);
        for(char c : numStr.toCharArray()){
            res.add(Integer.parseInt(String.valueOf(c)));// 注意：这里不能直接(int)c，会变为ascii
        }
        return res;
    }

    public List<Integer> addToArrayForm1(int[] num, int k) {
        // 链表法
        // while(nums遍历没结束 || k遍历没结束)
        // nums当前位置x
        // k当前位y为 k % 10，遍历过程为 k /= 10
        // res当前位z为 (x+y+carry) % 10
        // carry为 (x+y) / 10 + carry
        // 每次都通过 res.addFirst(z)
        // while循环结束后，检查carry是否有剩余进位
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        int n = num.length - 1;
        while(n >= 0 || k > 0){
            int x = n >= 0 ? num[n] : 0;
            int y = k > 0 ? k % 10 : 0;
            int z = (x+y+carry) % 10;
            carry = (x+y+carry) / 10;
            res.addFirst(z);
            k /= 10;
            n --;
        }
        if(carry > 0){
            res.addFirst(carry);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{9,9,9};
        int k = 181;
        List<Integer> res = solution.addToArrayForm1(nums,k);
        System.out.println(res.toString());
    }
}
