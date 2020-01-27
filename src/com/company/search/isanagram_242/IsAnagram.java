package com.company.search.isanagram_242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    private static boolean isAnagram(String s, String t) {
        //时间复杂度：O(n)
        //空间复杂度：O(n)
        Map<Character, Integer> stringMap = new HashMap<>();
        if (s.length() != t.length()) return false;

        //统计字符串s中所有出现的字母及其出现频率
        for (int i = 0; i < s.length(); i++) {
            if (!stringMap.containsKey(s.charAt(i)))
                stringMap.put(s.charAt(i), 1);
            else
                stringMap.put(s.charAt(i), stringMap.get(s.charAt(i)) + 1);
        }

        //遍历字符串t所有字母，统计种类和数量是否与stringMap的一致
        for (int j = 0; j < t.length(); j++) {
            if (stringMap.containsKey(t.charAt(j))) {
                stringMap.put(t.charAt(j), stringMap.get(t.charAt(j)) - 1);
                if (stringMap.get(t.charAt(j)) < 0)
                    return false;
            } else return false;
        }

        return true;
    }

    private static boolean isAnagram_1(String s, String t) {
        //时间复杂度：O(nlogn)
        //空间复杂度：O(n)（toCharArray造成的，忽略此部分空间复杂度为O(1)）
        if (s.length() != t.length()) return false;

        //给两个字符串数组排序
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }

    private static boolean isAnagram_2(String s, String t) {
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (s.length() != t.length())
            return false;

        int[] alpha = new int[26];
        //遍历s时，hash表对应位置加，遍历t时，hash表对应位置减
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }

        //检查hash表所有元素是否都是0
        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return false;
        return true;
    }

    private static boolean isAnagram_3(String s, String t) {
        //时间复杂度：O(n)
        //空间复杂度：O(1)
        if (s.length() != t.length())
            return false;

        int[] alpha = new int[26];
        //遍历s时，hash表对应位置加，遍历t时，hash表对应位置减
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            alpha[t.charAt(i) - 'a']--;
            //如果存在小于零的字母，则直接判断错误
            if (alpha[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
