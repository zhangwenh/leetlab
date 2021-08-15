package io.rdk.leetlab.normal.p389_find_the_difference;

public class Solution {
    public char findTheDifference(String s, String t) {
        // 各string里的char进行相加，然后减掉另外一个
        // 再转换为char，就是结果
        long sl = 0;
        long tl = 0;
        for(char c: s.toCharArray()){
            sl += c;
        }
        for(char c: t.toCharArray()){
            tl += c;
        }
        return (char)(tl-sl);
    }
}
