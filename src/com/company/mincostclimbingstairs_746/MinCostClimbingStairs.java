package com.company.mincostclimbingstairs_746;

public class MinCostClimbingStairs {
    private static int minCostClimbingStairs(int[] cost) {
        int[] total = new int[cost.length];
        total[0] = cost[0];
        total[1] = cost[1];
        for (int i = 2; i < total.length; i++)
            total[i] = Math.min(total[i - 2] + cost[i], total[i - 1] + cost[i]);
        return Math.min(total[total.length - 1], total[total.length - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost_1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
        System.out.println(minCostClimbingStairs(cost_1));
    }
}
