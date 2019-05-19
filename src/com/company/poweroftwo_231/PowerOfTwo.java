package com.company.poweroftwo_231;

public class PowerOfTwo {
    private static boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        else if (n <= 0) return false;
        while (n % 2 == 0) {
            n /= 2;
            if (n == 1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(-100));
    }
}
