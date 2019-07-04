package com.company.calculateprimenumber_204;

public class CalculatePrimeNumber {
    //超时了
    private static int countPrimes(int n) {
        int i = 2;
        int num = 0;
        while (i < n) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    num++;
                    break;
                }
            }
            i++;
        }
        return n - num - 2 > 0 ? n - num - 2 : 0;
    }

    private static int countPrimes_1(int n) {
        boolean[] isPrime = new boolean[n];

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = 2 * i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        return count;
    }

    private static int countPrimes_2(int n) {
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < isPrime.length; i++) {  //首先标记全部标记为true
            isPrime[i] = true;
        }

        //(埃拉托斯特尼筛法)遍历数组，采用上述算法，标记是倍数的为false
        for (int i = 2; i * i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int res = 0;
        //统计出为true的，就是质数的总数
        for (boolean bool : isPrime) {
            res += bool ? 1 : 0;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes_1(10));
        System.out.println(countPrimes_2(21));
    }
}
