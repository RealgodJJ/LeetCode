package com.company.romantointeger_13;

public class RomanToInteger {
    private static int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    num += 5;
                    break;
                case 'X':
                    num += 10;
                    break;
                case 'L':
                    num += 50;
                    break;
                case 'C':
                    num += 100;
                    break;
                case 'D':
                    num += 500;
                    break;
                case 'M':
                    num += 1000;
                    break;
                default:
                    break;
            }

            if (i != 0) {
                if ((s.charAt(i) == 'V' || s.charAt(i) == 'X') && s.charAt(i - 1) == 'I')
                    num -= 2;
                if ((s.charAt(i) == 'L' || s.charAt(i) == 'C') && s.charAt(i - 1) == 'X')
                    num -= 20;
                if ((s.charAt(i) == 'D' || s.charAt(i) == 'M') && s.charAt(i - 1) == 'C')
                    num -= 200;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println(result);
    }
}
