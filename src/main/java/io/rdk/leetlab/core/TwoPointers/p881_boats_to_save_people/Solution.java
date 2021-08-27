package io.rdk.leetlab.core.TwoPointers.p881_boats_to_save_people;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        // 排序，大加小
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

//        Arrays.sort(people);
//        int res = 0;
//        // 轻->重
//        // 每艘船最多可同时载两人，因此双指针
//        for(int i = 0,j = people.length-1; i <= j;){
//            if(i == j){
//                res++;
//                j--;
//            }else{
//                int big = people[j];
//                int small = people[i];
//                if((big+small) > limit){ //只放大的
//                    res++;
//                    j--;
//                }else if((big+small) <= limit){ //放1大1小
//                    res++;
//                    i++;
//                    j--;
//                }
//            }
//        }
//        return res;
    }
}
