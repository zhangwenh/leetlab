package io.rdk.leetlab.normal.p704_binary_search;

public class Solution {
    public int search(int[] nums, int target) {
        // 二分查找
        // 由于排过序，因此可以用二分法
        int res = -1;
        int l = 0, r = nums.length - 1;
        int midPre = -1;
        while(l<=r){ // 注意：一定要带等号！！并且在后面判断复制时r=mid-1，l=mid+1
            int mid = l+(r-l)/2;
            if(mid == midPre){
                break;
            }
            midPre = mid;
            if(target == nums[mid]) {
                res = mid;
                break;
            }else if(target < nums[mid]){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        Solution solution = new Solution();
        int res = solution.search(nums, target);
        System.out.println(res);
    }
}
