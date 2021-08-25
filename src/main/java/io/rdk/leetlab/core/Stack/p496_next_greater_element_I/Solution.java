package io.rdk.leetlab.core.Stack.p496_next_greater_element_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0){
            return null;
        }
        Map<Integer,Integer> resMap = new HashMap<>(); // 存储当前数字第一个更大的值
        // 用栈来一次确定各数字右边第一个最大的值
        Stack<Integer> stack = new Stack<>();
        // 大值让stack里所有比它小的值出栈，并记录到map里
        // 随后把大值放进去
        // 结束循环后，stack里的值即为没有大值的数字
        for(int num2 : nums2){
            if(!stack.isEmpty()){
                // 和栈比较，栈中元素一定是最大的在最下面
                while(!stack.isEmpty()){
                    if(num2 > stack.peek()){
                        int temp = stack.pop();
                        resMap.put(temp,num2);
                    }else{
                        break;// 小的都出栈了
                    }
                }
            }
            // 把自己也放进去
            stack.add(num2);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = resMap.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        Solution s = new Solution();
        int[] ret = s.nextGreaterElement(nums1,nums2);
        System.out.println();
    }
}
