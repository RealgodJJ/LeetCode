package com.company.superuglynumber_313;

import java.util.Arrays;

public class SuperUglyNumber {
    private static int nthSuperUglyNumber_1(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int[] factors = new int[primes.length];
        int[] basics = Arrays.copyOf(primes, primes.length);

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                int factor = dp[factors[j]] * primes[j];
                basics[j] = factor;
                min = Math.min(min, factor);
            }
            dp[i] = min;

            for (int j = 0; j < primes.length; j++) {
                if (min == basics[j]) {
                    factors[j]++;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        System.out.println(nthSuperUglyNumber_1(n, primes));
    }
}
