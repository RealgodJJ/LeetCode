package com.company.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int num = 0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arrayN = new int[n];
        for (int i = 0; i < n; i++) {
            arrayN[i] = in.nextInt();
        }

        int m = in.nextInt();
        int[] arrayM = new int[n];
        for (int i = 0; i < m; i++) {
            arrayM[i] = in.nextInt();
        }

        for (int i = 1; i < arrayN.length; i++) {
            int temp = arrayN[i];
            int j = i - 1;
            while (j >= 0 && temp < arrayN[j]) {
                arrayN[j + 1] = arrayN[j];
                j--;
            }
            arrayN[j + 1] = temp;
        }

        for (int i = 1; i < arrayM.length; i++) {
            int temp = arrayM[i];
            int j = i - 1;
            while (j >= 0 && temp < arrayM[j]) {
                arrayM[j + 1] = arrayM[j];
                j--;
            }
            arrayM[j + 1] = temp;
        }

        for (int j = arrayM.length - 1; j >= 0; j--) {
            for (int i = arrayN.length - 1; i >= 0; i--) {
                if (arrayN[i] <= arrayM[j]) {
                    num++;
                    i--;
                    j--;
                }
            }
        }

        System.out.println(num);
    }
}
