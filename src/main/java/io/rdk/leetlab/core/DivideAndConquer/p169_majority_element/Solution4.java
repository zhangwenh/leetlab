package io.rdk.leetlab.core.DivideAndConquer.p169_majority_element;

/**
 * 摩尔投票法
 *
 * 两两比较，只要不同就都抵消kill，众数一定是最后剩下来
 *
 */
public class Solution4 {
    public int majorityElement(int[] nums) {
        int ans = 0, x = 0; //ans代表备选人，x代表备选人的票数
        for(int i = 0; i < nums.length; i++) {
            if(x == 0)  //如果当前备选人为0票，肯定就是没有备选人，直接找新备选人
                ans = nums[i];  //更新备选人
            x += ans == nums[i] ? 1 : -1;   //如果当前投的不是备选人，则x减一；是投的备选人，x加一
        }
        return ans;
    }
}
