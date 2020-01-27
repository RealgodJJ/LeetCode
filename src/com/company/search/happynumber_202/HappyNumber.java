package com.company.search.happynumber_202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    private static boolean isHappyNumber(int n) {
        //判断计算平方和的结果中是否存在4，一旦出现4就说明了它不是快乐数
        while (n != 1) {
            n = bitSquareSum(n);
            if (n == 4) return false;
        }
        return true;
    }

    private static boolean isHappyNumber_1(int n) {
        //判断计算平方和的结果次数超过10次，就说明了它不是快乐数
        if (n == 1) return true;

        int i = 0;
        while (i < 10) {
            n = bitSquareSum(n);
            i++;
            if (n == 1) return true;
        }
        return false;
    }

    private static boolean isHappyNumber_2(int n) {
        //判断计算平方和的结果是否发生重复，重复说明陷入结果循环，就说明了它不是快乐数
        if (n == 1) return true;
        Set<Integer> sumSet = new HashSet<>();

        while (true) {
            n = bitSquareSum(n);
            if (sumSet.contains(n))
                return false;
            sumSet.add(n);
            if (n == 1) return true;
        }
    }

    private static boolean isHappyNumber_3(int n) {
        //使用快慢两个指针，但二者相等时，说明到达循环周期
        int slow = n, fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(fast);
            fast = bitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private static int bitSquareSum(int n) {
        int result = 0;
        while (n > 0) {
            int remain = n % 10;
            result += Math.pow(remain, 2);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        boolean isHappyNumber = isHappyNumber(1231);
        System.out.println(isHappyNumber);

        boolean isHappyNumber_1 = isHappyNumber_1(1231);
        System.out.println(isHappyNumber_1);

        boolean isHappyNumber_2 = isHappyNumber_2(1231);
        System.out.println(isHappyNumber_2);

        boolean isHappyNumber_3 = isHappyNumber_3(1231);
        System.out.println(isHappyNumber_3);
    }
}
