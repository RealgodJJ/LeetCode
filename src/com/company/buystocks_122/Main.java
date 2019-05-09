package com.company.buystocks_122;

public class Main {
    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        GetMaxProfit getMaxProfit = new GetMaxProfit();
        System.out.println(getMaxProfit.easyMaxProfit(stocks));
    }
}
