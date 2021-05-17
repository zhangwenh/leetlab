package io.rdk.leetlab.core.Array.p27_remove_element;

public class Solution {

    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0){
            return 0;
        }else{
            int index = 0;
            for(int i =0;i<nums.length;i++){
                if(nums[i] != val){
                    nums[index++] = nums[i];
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{3,2,2,3};
        //输入：nums = [3,2,2,3], val = 3
        //输出：2, nums = [2,2]
        int ret = s.removeElement(arr,3);
        System.out.println(ret);
        for (int i : arr) {
            System.out.print(String.valueOf(i).concat(","));
        }
    }
}
