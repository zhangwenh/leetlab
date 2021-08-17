package io.rdk.leetlab.normal.p720_longest_word_in_dictionary;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String[] words = new String[]{"w","wo","wor","worl", "world"};
        Solution solution = new Solution();
        String res = solution.longestWord(words);
        System.out.println(res);
    }

    public String longestWord(String[] words) {
        // 暴力法
        String res = "";
        // 利用hashset存储word，缩短查找匹配时间
        // 遍历words里每个值
        // 当word长度 > res，或者 word长度==res且字典序小于res时，进行下一步
        // 检查word的每个字母子集是否出现在hashset中
        // 若符合，则为res
        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);
        for(String word : words){
            int wordLen = word.length();
            int resLen = res.length();
            if(wordLen > resLen || (wordLen == resLen && word.compareTo(res)<0)){
                boolean isWord = true;
                for(int i = 0; i < wordLen; i++){
                    String subWord = word.substring(0,i+1);
                    if (!set.contains(subWord)) {
                        isWord = false;
                        break;
                    }
                }
                if(isWord){
                    res = word;
                }
            }
        }
        return res;
    }
}
