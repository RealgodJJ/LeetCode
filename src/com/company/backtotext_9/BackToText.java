package com.company.backtotext_9;

import com.company.addtwonumbers_2.AddTwoNumbers;

public class BackToText {
    private static boolean isPalindrome(int x) {
        int temp = x;
        int newNumber = 0;
        if (x < 0)
            return false;

        while (x != 0) {
            int remain = x % 10;
            newNumber = newNumber * 10 + remain;
            x /= 10;
        }

        return newNumber == temp;
    }

    private static boolean isPalindromeFast(int x) {
        //仅仅颠倒数字的后半部分，很原本数字的前半部分进行比较
        if ((x < 0) || (x % 10 == 0 && x != 0)) {
            return false;
        }


        int reverse = 0;
        while (reverse < x) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return (x == reverse) || (x == reverse / 10);
    }

    public static void main(String[] args) {
//        boolean isPalindrome = isPalindromeFast(12321);
        boolean isPalindrome = isPalindromeFast(123321);
        System.out.println(isPalindrome);
    }
}
