package com.company.array.minwindow_76;

public class MinWindow {
    private static String minWindow(String s, String t) {
        //滑动窗口机制
        //时间复杂度：O(n)
        if (s == null || s.length() == 0 || t.length() == 0)
            return "";

        int[] needs = new int[128];
        int[] window = new int[128];
        for (char alpha : t.toCharArray())
            needs[alpha]++;

        int left = 0, right = 0, total = 0, minLength = s.length() + 1;
        int targetLeft = 0, targetRight = 0;
//        StringBuilder result = new StringBuilder();
        while (right < s.length()) {
            char chRight = s.charAt(right);
            if (needs[chRight] > 0) {
                window[chRight]++;
                if (window[chRight] <= needs[chRight])
                    total++;
            }

            while (total == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    targetLeft = left;
                    targetRight = right + 1;
//                    result.delete(0, result.length());
//                    for (int i = left; i <= right; i++) {
//                        result.append(s.charAt(i));
//                    }
                }

                char chLeft = s.charAt(left);
                if (needs[chLeft] > 0) {
                    window[chLeft]--;
                    if (window[chLeft] < needs[chLeft])
                        total--;
                }
                left++;
            }
            right++;
        }
//        return result.toString();
        //TODO：记录下遍历完成后最合适的左右指针即可
        return s.substring(targetLeft, targetRight);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);

        String s1 = "a";
        String t1 = "aa";
        String result1 = minWindow(s1, t1);
        System.out.println(result1);
    }
}
