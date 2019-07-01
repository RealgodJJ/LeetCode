package com.company.LongestPalindromeSubstring_5;

public class LongestPalindromeSubstring {
    private static int maxLen = 0;
    private static String sub = "";

    private static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int low = 0;
        int max = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = true;
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    dp[j][i] = s.charAt(j) == s.charAt(i);
                } else
                    dp[j][i] = dp[j + 1][i - 1] && (s.charAt(j) == s.charAt(i));

                if (dp[j][i] && i - j + 1 > max) {
                    max = i - j + 1;
                    low = j;
                }
            }
        }
        return s.substring(low, low + max);
    }

    public static void main(String[] args) {
        String a = "aaaa";
        String b = "babad";
        System.out.println(longestPalindrome(a));
        System.out.println(longestPalindrome(b));
    }
}
