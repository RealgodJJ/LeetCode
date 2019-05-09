package com.company.integerinversion_7;

public class IntegerInversion {
    public int reverse(int x) {
        int result = 0;
        int single;
        while (x != 0) {
            single = x % 10;
            x /= 10;

            //最后一次翻转超过了范围（x > 0）
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && single > 7)) {
                return 0;
            }
            //最后一次翻转超过了范围（x < 0）
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && single < -8)) {
                return 0;
            }

            result = result * 10 + single;
        }
        return result;
    }

    public int easyReverse(int x) {
        StringBuilder stringBuilder = new StringBuilder();

        //将数字转换成字符串
        String strResult = String.valueOf(Math.abs((long) x));
        int length = strResult.length();

        //形成字符串的翻转
        while (length > 0) {
            stringBuilder.append(strResult.charAt(length - 1));
            length--;
        }

        //将字符串转回Long型(转换成Long型是因为可以最后确定是否超过了阈值范围)
        Long longResult = Long.parseLong(stringBuilder.toString());
        if (longResult > Integer.MAX_VALUE) {
            return 0;
        }

        //给数值赋予正负
        if (x >= 0)
            return longResult.intValue();
        else
            return -longResult.intValue();
    }
}
