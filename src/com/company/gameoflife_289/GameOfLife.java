package com.company.gameoflife_289;

public class GameOfLife {
    private static void gameOfLife(int[][] board) {
        int alive;
//        int[][] newBoard = new int[board.length][board[0].length];
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                newBoard[i][j] = board[i][j];
//            }
//        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                alive = 0;
                //1.统计周围格子中活细胞中的数量
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] % 2 == 1) alive++;
                if (i - 1 >= 0 && board[i - 1][j] % 2 == 1) alive++;
                if (i - 1 >= 0 && j + 1 < board[0].length && board[i - 1][j + 1] % 2 == 1) alive++;
                if (j - 1 >= 0 && board[i][j - 1] % 2 == 1) alive++;
                if (j + 1 < board[0].length && board[i][j + 1] % 2 == 1) alive++;
                if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] % 2 == 1) alive++;
                if (i + 1 < board.length && board[i + 1][j] % 2 == 1) alive++;
                if (i + 1 < board.length && j + 1 < board[0].length && board[i + 1][j + 1] % 2 == 1) alive++;

                //2.分析该细胞是存活还是死亡
//                if (board[i][j] == 1 && alive < 2) newBoard[i][j] = 0;
//                else if (board[i][j] == 1 && alive > 3) newBoard[i][j] = 0;
//                else if (board[i][j] == 0 && alive == 3) newBoard[i][j] = 1;

                //“2”表示由死细胞转变为活细胞。“3”表示有活细胞转变为死细胞
                if (board[i][j] == 1 && (alive < 2 || alive > 3)) board[i][j] = 3;
                else if (board[i][j] == 0 && alive == 3) board[i][j] = 2;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) board[i][j] = 1;
                if (board[i][j] == 3) board[i][j] = 0;
            }
        }

//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                board[i][j] = newBoard[i][j];
//            }
//        }
    }


    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
