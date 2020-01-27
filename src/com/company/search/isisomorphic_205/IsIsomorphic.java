package com.company.search.isisomorphic_205;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    private static boolean isIsomorphic(String s, String t) {
        //调用两次Map映射，实现字母之间的相互映射
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private static boolean isIsomorphicHelper(String s1, String s2) {
        Map<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (!charMap.containsKey(s1.charAt(i)))
                charMap.put(s1.charAt(i), s2.charAt(i));
            else if (charMap.get(s1.charAt(i)) != s2.charAt(i))
                return false;
        }

        return true;
    }

    private static boolean isIsomorphic_1(String s, String t) {
        return isIsomorphicHelper_1(s).equals(isIsomorphicHelper_1(t));
    }

    private static String isIsomorphicHelper_1(String s) {
        //将两个字符串都装换成位置数组，保证两个位置数组相同即互为同构词
        int[] map = new int[128];
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //当前字母第一次出现,赋值
            if (map[c] == 0) {
                map[c] = count;
                count++;
            }
            sb.append(map[c]);
        }
        return sb.toString();
    }

    private static boolean isIsomorphic_2(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            //同一种字母判断第一次出现的位置是否相同
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
                return false;
        }
        return true;
    }

    private static boolean isIsomorphic_3(String s, String t) {
        //两个字符串数组互相映射
        char[] s2t = new char[127];
        char[] t2s = new char[127];
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (s2t[S[i]] != '\0' || t2s[T[i]] != '\0') {
                if (s2t[S[i]] != T[i]) {
                    return false;
                }
            } else {
                s2t[S[i]] = T[i];
                t2s[T[i]] = S[i];
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        String s1 = "egg";
        String t1 = "add";

        System.out.println(isIsomorphic(s, t));
        System.out.println(isIsomorphic(s1, t1));

        System.out.println(isIsomorphic_1(s, t));
        System.out.println(isIsomorphic_1(s1, t1));

        System.out.println(isIsomorphic_2(s, t));
        System.out.println(isIsomorphic_2(s1, t1));

        System.out.println(isIsomorphic_3(s, t));
        System.out.println(isIsomorphic_3(s1, t1));
    }
}
