package com.company.lightbulbswitch_319;

public class LightBulbSwitch {
    //本题转换成判断灯泡的数量得公因子数量是否为奇数，即该数是否是完全平方数
    private static int bulbSwitch(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (Math.pow(i, 2) <= n) {
                num++;
            }
        }
        return num;
    }

    private static int bulbSwitch_1(int n) {
        int num = 0;
        for (int i = 1; Math.pow(i, 2) <= n; i++) {
            num++;
        }
        return num;
    }

    private static int bulbSwitch_2(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++)
            System.out.println(bulbSwitch_2(i));
    }
}
