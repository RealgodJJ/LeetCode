package com.company.longestcommonprefix_14;

public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //这里不断判断后者是否在前者字符串中出现
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    private static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        StringBuilder sb = new StringBuilder();
        int min = strs[0].length();
        int[] length = new int[strs.length - 1];

        //获取所有字符串中的最短字符串长度
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
            }
        }

        //获得字符对比重复长度的数组
        for (int i = 1; i < strs.length; i++) {
            int twoLength = 0;
            for (int j = 1; j < min + 1; j++) {
                if (prefix.substring(0, j).equals(strs[i].substring(0, j))) {
                    twoLength++;
                }
            }
            length[i - 1] = twoLength;
        }

        //获得字符对比重复长度的数组的最小值
        for (int i = 0; i < length.length; i++) {
            if (min > length[i]) {
                min = length[i];
            }
        }
        sb.append(strs[0], 0, min);
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] words = {"flower", "flow", "flight"};
//        String[] words = {"dog", "racecar", "car"};
//        String[] words = {};
        String[] words = {""};
//        String[] words = {"c", "c"};
        System.out.println(longestCommonPrefix1(words));
    }
}
