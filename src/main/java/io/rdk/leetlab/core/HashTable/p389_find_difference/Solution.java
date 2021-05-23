package io.rdk.leetlab.core.HashTable.p389_find_difference;

class Solution {
    public char findTheDifference(String s, String t) {
        long sl = 0;
        long tl = 0;
        for (int i = 0; i < s.length(); i++) {
            sl += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            tl += t.charAt(i);
        }
        return (char)(tl-sl);
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        Solution so = new Solution();
        char c = so.findTheDifference(s,t);
        System.out.println(c);
    }
}