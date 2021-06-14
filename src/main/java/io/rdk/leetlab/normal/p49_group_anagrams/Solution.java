package io.rdk.leetlab.normal.p49_group_anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 对每个字符串中的字母进行排序，将排序后的字符串作为key，原字符串作为value，存储到map
        // 该map的value为List<String>
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);// 每个字母排序
            String sortedStr = new String(arr);
            List<String> valueList = map.getOrDefault(sortedStr, new ArrayList<>());
            valueList.add(str);
            map.put(sortedStr, valueList);
        }
        return new ArrayList<>(map.values());
//        List<List<String>> res = new ArrayList<>();
//        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
//            res.add(stringListEntry.getValue());
//        }
//        return res;
    }
}
