package io.rdk.leetlab.core.Array.p283_move_zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums!=null && nums.length>1){
            int index = 0;
            for(int i = 0; i<nums.length; i++){
                if(nums[i]!=0){ // 若为0，则用下一个非0值代替
                    nums[index] = nums[i];
                    index++;
                }
            }
            for(int i = index; i<nums.length; i++){ // 填0
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{0,1,0,3,12};
        arr = new int[]{0,1,1,0};
        //int[] ret = new int[]{1,3,12,0,0};
        s.moveZeroes(arr);
        System.out.println("");
        for (int i : arr) {
            System.out.print(String.valueOf(i).concat(","));
        }
    }
}
