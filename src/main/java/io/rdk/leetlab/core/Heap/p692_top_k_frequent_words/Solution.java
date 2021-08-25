package io.rdk.leetlab.core.Heap.p692_top_k_frequent_words;

import java.util.*;

/**
 * 使用大根堆，并设置排序比较方法
 */
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // hashmap解决计数的问题
        // heap解决前k的问题
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> q = new PriorityQueue<>((o1, o2) -> {
            Integer o1Count = map.get(o1);
            Integer o2Count = map.get(o2);
            if (o1Count.equals(o2Count)) {
                return o1.compareTo(o2); // 出现次数相同，按字母顺序排序
            } else {
                return o2Count - o1Count; // 按单词出现次数由高到低排序
            }
        });

        // keySet() 方法返回值是 Map 中 key 值的集合
        q.addAll(map.keySet());

        List<String> res = new ArrayList<>();
        while(k > 0 && !q.isEmpty()){
            res.add(q.poll());
            k--;
        }
        return res;
    }
}
