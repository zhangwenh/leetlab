package io.rdk.leetlab.core.DivideAndConquer.p169_majority_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表法，性能非常不好
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num,counts.getOrDefault(num,0)+1);
        }
        return counts;
    }
}
