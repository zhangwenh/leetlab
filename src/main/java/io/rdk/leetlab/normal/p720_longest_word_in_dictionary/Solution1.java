package io.rdk.leetlab.normal.p720_longest_word_in_dictionary;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
        String[] words = new String[]{"w","wo","wor","worl", "world"};
        Solution1 solution = new Solution1();
        String res = solution.longestWord(words);
        System.out.println(res);
    }

    public String longestWord(String[] words) {
        // trie法
        if(words == null || words.length == 0){
            return "";
        }
        Trie root = new Trie();
        // 遍历后，构造trie树
        for(String word : words){
            Trie cur = root;
            for(char c : word.toCharArray()){
                if(cur.children.containsKey(c)){
                    // 如果有这个字符，则移动指向到下一个字符
                    cur = cur.children.get(c);
                }else{
                    // 没有，则创建一个新节点
                    Trie newNode = new Trie();
                    cur.children.put(c, newNode);
                    cur = newNode;
                }
            }
            cur.val = word; // 记录整体的字符串
            cur.isEnd = true; // 表示到达末尾了
        }
        // 查找匹配的单词
        String res = "";
        for(String word : words){
            Trie cur = root;
            if(word.length()>res.length() || (word.length() == res.length() && word.compareTo(res)<0)){
                boolean isWord = true;
                for(char c : word.toCharArray()){
                    cur = cur.children.get(c);
                    if(!cur.isEnd){
                        isWord = false;
                        break;
                    }
                }
                res = isWord ? word : res;
            }
        }
        return res;
    }

    class Trie {
        public HashMap<Character, Trie> children = new HashMap<>();
        public boolean isEnd = false;
        public String val = null;
    }

}
