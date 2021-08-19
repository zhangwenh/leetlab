package io.rdk.leetlab.normal.p211_design_add_and_search_words_data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDictionary {
    /** Initialize your data structure here. */
    private Map<Integer, List<String>> maps; // <length, words>

    public WordDictionary() {
        maps = new HashMap<>();
    }

    public void addWord(String word) {
        int key = word.length();
        if(maps.containsKey(key)) {
            List<String> valueList = maps.get(key);
            valueList.add(word);
        }else {
            List<String> value = new ArrayList<>();
            value.add(word);
            maps.put(key,value);
        }
    }

    public boolean search(String word) {
        int key = word.length();
        if(!maps.containsKey(key)) return false;
        List<String> valueList = maps.get(key);
        boolean flag = true;
        for (String value : valueList) {
            flag = true;
            for (int i = 0; i < value.length(); i++) {
                char w = word.charAt(i);
                if(w == '.') {
                    continue;
                }else {
                    char v = value.charAt(i);
                    if(w == v) {
                        continue;
                    }else {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                return true;
            }
        }
        return false;
    }
}



/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
