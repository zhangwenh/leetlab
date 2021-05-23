package io.rdk.leetlab.core.DivideAndConquer.p169_majority_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 随机法
 * 由于一个给定的下标对应的数字很有可能是众数，
 * 我们随机挑选一个下标，检查它是否是众数，如果是就返回，否则继续随机挑选。
 */
public class Solution2 {
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
    }
}
