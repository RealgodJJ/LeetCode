package com.company.search.wordpattern_290;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
    private static boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.indexOf(pattern.charAt(i)) != indexOfStr(strings, strings[i]))
                return false;
        }

        return true;
    }

    //返回在strings中第一个出现str的地方
    private static int indexOfStr(String[] strings, String str) {
        int index = -1;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(str))
                return i;
        }
        return index;
    }

    private static boolean wordPattern_1(String pattern, String str) {
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length)
            return false;

        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            //HashMap中的put方法返回值是与key相关联的旧值
            Integer put1 = map.put(strings[i], i);
            Integer put2 = map.put(pattern.charAt(i), i);
            if (!Objects.equals(put1, put2))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abbaba";
        String str = "dog cat cat dog cat dog";
//        String str = "a b b a";

        System.out.println(wordPattern(pattern, str));
        System.out.println(wordPattern_1(pattern, str));
    }
}
