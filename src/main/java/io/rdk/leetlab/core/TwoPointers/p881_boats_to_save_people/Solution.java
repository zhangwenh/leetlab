package io.rdk.leetlab.core.TwoPointers.p881_boats_to_save_people;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // 先排序, count = 0
        // [left,....,right] 左最小，右最大
        // count++,right--
        // if leftVal+rightVal<=limit，则left++
        int count = 0;
        Arrays.sort(people);
        int left = 0,right = people.length-1;
        while (left <= right) {
            count++;
            if (people[left] + people[right] <= limit)
                left++;
            right--;
        }
        return count;
    }
}
