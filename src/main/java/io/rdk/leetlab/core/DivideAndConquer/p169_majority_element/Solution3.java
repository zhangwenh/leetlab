package io.rdk.leetlab.core.DivideAndConquer.p169_majority_element;

/**
 * 分治法
 * 如果我们将 nums 分成两部分，那么 a 必定是至少一部分的众数
 * 将数组分成左右两部分，分别求出左半部分的众数 a1 以及右半部分的众数 a2，
 * 随后在 a1 和 a2 中选出正确的众数
 */
public class Solution3 {

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // 如果只有一个元素，那么一定是最大的
        if (lo == hi) {
            return nums[lo];
        }
        // 分治，将数组划分为左右两边
        int mid = lo+(hi-lo)/2;
        // 递归计算左右数组中的众数
        int leftNum =  majorityElementRec(nums,lo,mid);
        int rightNum = majorityElementRec(nums,mid+1,hi);
        // 如果左右两边两个元素一样，那么直接返回
        if(leftNum == rightNum){
            return leftNum;
        }
        // 如果不一样，则分别统计左右选举出的数字在整个范围内谁多
        int leftNumCnt = countInRange(nums,leftNum,lo,hi);
        int rightNumCnt = countInRange(nums,rightNum,lo,hi);

        return leftNumCnt>=rightNumCnt?leftNum:rightNum;
    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int cnt = 0;
        for (int i = lo; i <= hi; i++) {
            if(nums[i] == num){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,9,8,9,8};
        Solution3 s = new Solution3();
        int ret = s.majorityElement(arr);
        System.out.println(ret);
    }

}
