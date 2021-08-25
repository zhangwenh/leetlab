package io.rdk.leetlab.core.SlidingWindow.p1456_maximum_number_of_vowels_in_a_subs_tring_of_given_length;

class Solution {
    public int maxVowels(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0 || k>s.length()){
            return 0;
        }
        char[] charArr = s.toCharArray();
        int tempCnt = 0;
        for (int i = 0; i < k; i++) {
            tempCnt += isVowel(charArr[i]);
        }
        int res = tempCnt;
        for (int i = k; i < charArr.length; i++) {
            int curPrev = isVowel(charArr[i-k]);
            int curTail = isVowel(charArr[i]);
            tempCnt = tempCnt-curPrev+curTail;
            res = Math.max(res,tempCnt);
        }
        return res;
    }
    private int isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ? 1 : 0;
    }

    public static void main(String[] args) {
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        int k = 33;
        Solution solution = new Solution();
        int ret = solution.maxVowels(s,k);
        System.out.println(ret);
    }
}