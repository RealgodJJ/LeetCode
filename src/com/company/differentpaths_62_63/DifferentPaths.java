package com.company.differentpaths_62_63;

public class DifferentPaths {
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                else dp[i][j] = 1;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(4, 4));
        System.out.println(uniquePaths(3, 7));
    }
}
