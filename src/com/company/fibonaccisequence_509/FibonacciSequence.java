package com.company.fibonaccisequence_509;

public class FibonacciSequence {
    private static int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            int a = 0, b = 1, k = 2;
            int result = 0;
            while (k <= N) {
                result = a + b;
                a = b;
                b = result;
                k++;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int num = fib(10);
        System.out.println(num);
    }
}
