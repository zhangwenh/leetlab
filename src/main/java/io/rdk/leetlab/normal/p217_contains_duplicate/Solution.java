package io.rdk.leetlab.normal.p217_contains_duplicate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.add(num)){
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                return true;
            }else{
                map.put(num,num);
            }
        }
        return false;
    }
}
