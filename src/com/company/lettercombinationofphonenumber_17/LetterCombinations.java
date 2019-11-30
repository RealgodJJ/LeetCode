package com.company.lettercombinationofphonenumber_17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    private static List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        String[] result = new String[digits.length()];

        if (result.length == 0)
            return resultList;

        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    result[i] = "abc";
                    break;
                case '3':
                    result[i] = "def";
                    break;
                case '4':
                    result[i] = "ghi";
                    break;
                case '5':
                    result[i] = "jkl";
                    break;
                case '6':
                    result[i] = "mno";
                    break;
                case '7':
                    result[i] = "pqrs";
                    break;
                case '8':
                    result[i] = "tuv";
                    break;
                case '9':
                    result[i] = "wxyz";
                    break;
            }
        }

        resultList = getStringWithFor(result, 0, resultList, "");
        return resultList;
    }

    private static List<String> getStringWithFor(String[] result, int i, List<String> list, String stemp) {

        if (i < result.length - 1) {
            for (int j = 0; j < result[i].length(); j++) {
                list = getStringWithFor(result, i + 1, list, stemp + result[i].charAt(j));
            }
            i++;
        } else {
            for (int j = 0; j < result[i].length(); j++) {
                list.add(stemp + result[i].charAt(j));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
    }
}
