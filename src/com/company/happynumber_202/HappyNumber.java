package com.company.happynumber_202;

public class HappyNumber {
    private static boolean isHappyNumber(int n) {
        int remain;
        while (n != 1) {
            int result = 0;
            while (n > 0) {
                remain = n % 10;
                result += Math.pow(remain, 2);
                n /= 10;
            }
            n = result;
            if (n == 4) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isHappyNumber = isHappyNumber(1231);
        System.out.println(isHappyNumber);
    }
}
