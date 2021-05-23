package io.rdk.leetlab.core.Stack.p496_next_greater_element_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0){
            return null;
        }
        int[] retArr = new int[nums1.length];
        Map<Integer,Integer> tempMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num2 : nums2) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    int temp = stack.peek();
                    if (num2 > temp) {
                        stack.pop();
                        tempMap.put(temp, num2);
                    } else {
                        break;
                    }
                }
            }
            stack.add(num2);
        }
        for (int i=0;i<nums1.length;i++) {
            retArr[i] = tempMap.getOrDefault(nums1[i],-1);
        }

        return retArr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3,5,2,4};
        int[] nums2 = new int[]{6,5,4,3,2,1,7};
        Solution s = new Solution();
        int[] ret = s.nextGreaterElement(nums1,nums2);
        System.out.println();
    }
}
