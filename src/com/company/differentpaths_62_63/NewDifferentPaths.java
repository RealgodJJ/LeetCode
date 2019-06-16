package com.company.differentpaths_62_63;

public class NewDifferentPaths {
    private static int uniqueWithObstacles(int[][] obstacleGrid) {
//        1、新建一个长度为列数的一维数组，并赋初始值，第一行的障碍物前的格子都赋值为1；
//        2、逐行、逐列进行遍历。
//        3、在进行列的遍历之前，需要对当前行的第一个格子进行判断，如果是障碍物的话，则置为0；
//        4、进行列遍历时，判断当前格子是否为障碍物，是则置为0，否则再判断上一个格子是否为障碍物，不是的话就dp[j]+=dp[j-1]，此时dp[j]的值便是可到达obstacleGrid[i][j]的所有不同的路径总数
//        5、遍历结束之后，dp[n-1]便是总的不同的路径数了。
//
//        小优化：针对最右下角的格子是障碍物的特殊情况直接返回0；
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;

        if (obstacleGrid[x - 1][y - 1] == 1)
            return 0;

        //第一行障碍物前的格子都设置为1
        int[] dp = new int[y];
        for (int i = 0; i < y; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            else dp[i] = 1;
        }

        //
        for (int i = 1; i < x; i++) {
            dp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for (int j = 1; j < y; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[j] += obstacleGrid[i][j - 1] == 1 ? 0 : dp[j - 1];
                }
                else dp[j] = 0;
            }
        }
        return dp[y - 1];
    }

    private static int uniqueWithObstacles_1(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first column
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // Filling the values for the first row
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        // Starting from cell(1,1) fill up the values
        // No. of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
        // i.e. From above and left.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        // Return value stored in rightmost bottommost cell. That is the destination.
        return obstacleGrid[R - 1][C - 1];
    }

    public static void main(String[] args) {
        int[][] path_0 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int[][] path_1 = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniqueWithObstacles(path_0));
        System.out.println(uniqueWithObstacles_1(path_1));
    }
}
