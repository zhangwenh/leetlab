package io.rdk.leetlab.core.Set.p217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
               return true;
            }
        }
        return false;
    }
}