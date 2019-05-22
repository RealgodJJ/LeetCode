package com.company.poweroftwo_231;

public class PowerOfTwo {
    private static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        else if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPowerOfTwo_1(int n) {
        //按位与的方式（16二进制的1000,15的二进制是0111）
        return n > 0 && ((n & (n - 1)) == 0);
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo_1(16));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo_1(1));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo_1(0));
        System.out.println(isPowerOfTwo(-100));
        System.out.println(isPowerOfTwo_1(-100));
    }
}
