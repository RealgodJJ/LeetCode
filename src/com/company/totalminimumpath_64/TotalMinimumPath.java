package com.company.totalminimumpath_64;

public class TotalMinimumPath {
    //时间复杂度为O(mn)，空间复杂度为O(mn)
    private static int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] dp = new int[x][y];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0)
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if (j == 0)
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[x - 1][y - 1];
    }

    //时间复杂度为O(mn)，空间复杂度为O(1)
    private static int minPathSum_1(int[][] grid) {
        for (int i = 0; i <= grid.length - 1; i++) {
            for (int j = 0; j <= grid[0].length - 1; j++) {
                if (i == 0 && j != 0)
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if (j == 0 && i != 0)
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                else if (j != 0)
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] pathLength = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] fuck = minPathSum(pathLength);
//        for (int i = 0; i < pathLength.length; i++) {
//            for (int j = 0; j < pathLength[0].length; j++) {
//                System.out.println(fuck[i][j]);
//            }
//        }
        System.out.println(minPathSum_1(pathLength));
    }
}
