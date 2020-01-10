package com.company.array.ispalindrome_125;

public class IsPalindrome {
    private static boolean isPalindrome(String s) {
        //时间复杂度：O(n)
        //双指针碰撞
        int l = 0, r = s.length() - 1;
        while (l < r) {
            //不断循环排除数字和字母以外的所有符号
            while ((l < r) && !((s.charAt(l) >= 48 && s.charAt(l) <= 57) || (s.charAt(l) >= 97 && s.charAt(l) <= 122) ||
                    (s.charAt(l) >= 65 && s.charAt(l) <= 90)))
                l++;

            while ((l < r) && !((s.charAt(r) >= 48 && s.charAt(r) <= 57) || (s.charAt(r) >= 97 && s.charAt(r) <= 122) ||
                    (s.charAt(r) >= 65 && s.charAt(r) <= 90)))
                r--;

            //不区分大小写
            if (Character.toUpperCase(s.charAt(l)) == Character.toUpperCase(s.charAt(r))) {
                l++;
                r--;
            } else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));
        String s2 = "race a car";
        System.out.println(isPalindrome(s2));
        String s3 = ",.";
        System.out.println(isPalindrome(s3));
        String s4 = "0P";
        System.out.println(isPalindrome(s4));
    }
}
