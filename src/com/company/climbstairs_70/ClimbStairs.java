package com.company.climbstairs_70;

public class ClimbStairs {
    //递归会超出时间的限制
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    private static int climbStairs_1(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1, b = 2, k = 3;
            int result = 0;
            while (k <= n) {
                result = a + b;
                a = b;
                b = result;
                k++;
            }
            return result;
        }
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(climbStairs_1(n));
    }
}
