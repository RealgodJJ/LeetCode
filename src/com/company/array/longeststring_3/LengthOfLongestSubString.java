package com.company.array.longeststring_3;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubString {

    private static int lengthOfLongestSubStringStupid(String s) {
        //时间复杂度：O(n)
        //利用滑动窗口的机制
        int maxLength = 0;
        int j = 0, k = 0;
        Map<Character, Boolean> alphabets = new HashMap<>();
        while (j < s.length() && k < s.length()) {
            char alpha = s.toCharArray()[k];
//            char a = s.charAt(k);
            if (!alphabets.containsKey(alpha) || !alphabets.get(alpha)) {
                alphabets.put(alpha, true);
                k++;
                maxLength = Math.max(k - j, maxLength);
            } else {
                alpha = s.toCharArray()[j];
//                char a = s.charAt(j);
                alphabets.put(alpha, false);
                j++;
            }
        }
        return maxLength;
    }

    private static int lengthOfLongestSubString(String s) {
        //时间复杂度：O(n)
        //利用滑动窗口的机制
        int[] hash = new int[128];
        int max = 0;
        int i = 0, j = 0;

        while (i < s.length() && j < s.length()) {
            if (hash[s.charAt(j)] == 0) {
                //之前没有出现过这个字符
                hash[s.charAt(j)] = 1;
                j++;
                max = Math.max(j - i, max);
            } else {
                //之前出现过这个字符
                hash[s.charAt(i)] = 0;
                i++;
            }
        }
        return max;
    }

    private static int lengthOfLongestSubStringFast(String s) {
        //时间复杂度：O(n)
        //利用滑动窗口的机制
        int[] index = new int[128];
        int maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            //（1）确定第一次出现该字符的位置（2）更新重复字符的最新位置
            i = Math.max(index[s.charAt(j)], i);
            //每次比较当前最大长度和产生重复之后的当前长度
            maxLength = Math.max(maxLength, j - i + 1);
            index[s.charAt(j)] = j + 1 ;
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        String s = "pwwkew";
//        String s = "abcabcbb";
//        String s = "bbb";
//        String s = "dvdf";
        String s = "tmmzuxtx";
        int length_1 = lengthOfLongestSubStringStupid(s);
        int length_2 = lengthOfLongestSubString(s);
        int length_3 = lengthOfLongestSubStringFast(s);
        System.out.println(length_1);
        System.out.println(length_2);
        System.out.println(length_3);
    }
}