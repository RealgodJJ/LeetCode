package com.company.array.reversestring_344;

public class ReverseString {
    private static void reverseString(char[] s) {
        //时间复杂度：O(n)
        //双指针碰撞
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }

    private static void reverseString_1(char[] s) {
        //时间复杂度：O(n)
        //递归
        judge(s, 0, s.length - 1);
    }

    private static void judge(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left++] = s[right];
        s[right--] = temp;
        judge(s, left, right);
    }

    public static void main(String[] args) {
        char[] s1 = {'H', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        for (char s : s1)
            System.out.println(s);

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString_1(s2);
        for (char s : s2)
            System.out.println(s);
    }
}
