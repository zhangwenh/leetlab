package io.rdk.leetlab.core.Heap.p692_top_k_frequent_words;

import java.util.*;

/**
 * 使用set，并设置排序比较方法
 */
class Solution1 {
    public List<String> topKFrequent(String[] words, int k) {
        if(words == null || k == 0){
            return null;
        }
        // 先将words放到hashmap<word,count>中；word放到ArrayList中
        Map<String ,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        // 重新定义arraylist排序方法
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cnt1 = map.get(o1);
                int cnt2 = map.get(o2);
                if(cnt1 == cnt2){ // 若count一样，则按字母序
                    return o1.compareTo(o2);
                }else{
                    return cnt2 - cnt1;
                }
            }
        });
        // 返回list的前k对象
        return list.subList(0,k);
    }
}
