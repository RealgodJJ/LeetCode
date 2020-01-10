package com.company.array.findanagrams_438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {
    private static List<Integer> findAnagrams_1(String s, String p) {
        //滑动窗口机制
        //时间复杂度：O(n^2) 超过时间限制
        int[] hashNum = new int[26];    //用于统计p中字母出现以及它的个数
        for (char alpha : p.toCharArray()) {
            hashNum[alpha - 97]++;
        }

        int[] hashNumCopy = new int[hashNum.length];
        System.arraycopy(hashNum, 0, hashNumCopy, 0, hashNumCopy.length);

        int i = 0, j = -1;  //设定在字符串s的[i, j]区间寻找
        List<Integer> results = new ArrayList<>();
        while (i < s.length()) {
            if (j + 1 < s.length() && hashNum[s.toCharArray()[j + 1] - 97] != 0) {
                hashNum[s.toCharArray()[++j] - 97]--;
            } else {
                i++;
                System.arraycopy(hashNumCopy, 0, hashNum, 0, hashNum.length);
            }

            int flag = 0;
            //以下步骤面对过长的字符串s是很高的时间代价
            for (int hash : hashNum) {
                if (hash != 0) {
                    flag = 1;
                    break;
                }
            }

            //找到了一个解
            if (flag == 0) {
                results.add(i);
                i++;
                System.arraycopy(hashNumCopy, 0, hashNum, 0, hashNum.length);
            }
        }

        return results;
    }

    private static List<Integer> findAnagrams_2(String s, String p) {
        //滑动窗口机制
        //时间复杂度：O(n * k) 超过时间限制
        Map<Character, Integer> pMap = initMap(p);//用于统计p中字母出现以及对应的个数

        int i = 0, j = -1;  //设定在字符串s的[i, j]区间寻找
        List<Integer> results = new ArrayList<>();
        while (i < s.length()) {
            if (j + 1 < s.length() && pMap.containsKey(s.toCharArray()[j + 1])) {
                j++;
                pMap.put(s.toCharArray()[j], pMap.get(s.toCharArray()[j]) - 1);
            } else {
                i++;
                j = i - 1;
                pMap = initMap(p);
            }

            boolean flag = true;
            for (int times : pMap.values()) {
                if (times != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                results.add(i);
                i++;
                j = i - 1;
                pMap = initMap(p);
            }
        }

        return results;
    }

    private static Map<Character, Integer> initMap(String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        for (char alpha : p.toCharArray()) {
            if (!pMap.containsKey(alpha))
                pMap.put(alpha, 1);
            else pMap.put(alpha, pMap.get(alpha) + 1);
        }

        return pMap;
    }

    private static List<Integer> findAnagrams_3(String s, String p) {
        //滑动窗口机制(右指针向右寻找可行解，左指针向右不断优化，寻找最优解)
        //时间复杂度：O(n^2)
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        for (char alpha : p.toCharArray()) {
            needs[alpha - 'a']++;
        }

        int left = 0, right = 0, total = 0; //用total检测窗口中是否已经涵盖了p中的字符
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (needs[ch - 'a'] > 0) {  //检测哪些字母是需要出现的
                window[ch - 'a']++; //检测滑动窗口中出现字母的次数
                if (window[ch - 'a'] <= needs[ch - 'a']) //在没有达到次数之前，统计p中出现的字母在s窗体内的字母数量
                    total++;
            }

            while (total == p.length()) {   //判断是否已经包含了至少p中的所有字母要求的个数
                if (right - left + 1 == p.length())  //判断子串的长度是否为p的长度
                    results.add(left);
//                char chLeft = s.toCharArray()[left];  //TODO: 费时
                char ch1 = s.charAt(left);
                if (needs[ch1 - 'a'] > 0) { //判断是否有多出的在p中的字母，排除该指针对应的字母个数
                    window[ch1 - 'a']--;
                    if (window[ch1 - 'a'] < needs[ch1 - 'a'])
                        total--;
                }
                left++;
            }
            right++;
        }
        return results;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> results = findAnagrams_3(s, p);
        for (int result : results)
            System.out.println(result);
    }
}
