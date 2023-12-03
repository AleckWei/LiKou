package com.wwj.likoute.martix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author AleckWei
 * @detail 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：
 * 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 */
public class LiveGameTest {

    @Test
    public void fun() {
        int[][] board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);

        System.out.println(Arrays.deepToString(board));
    }

    public void gameOfLife(int[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;

        int[][] newMatrix = new int[rowLength][colLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                // 先获取自身的存活状态
                int currentLive = board[i][j];

                // 然后获取周围一圈的存活状态
                int liveNum = 0;
                int startRow = Math.max(i - 1, 0);
                int endRow = Math.min(i + 1, rowLength - 1);
                int startCol = Math.max(j - 1, 0);
                int endCol = Math.min(j + 1, colLength - 1);

                for (int k = startRow; k <= endRow; k++) {
                    for (int l = startCol; l <= endCol; l++) {
                        liveNum += board[k][l];
                    }
                }

                liveNum -= board[i][j];
//                System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 周围存活数量：" + liveNum);


                if (currentLive == 1) {
                    if (liveNum < 2) {
                        newMatrix[i][j] = 0;
//                        System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 最终死亡");
                    } else if (liveNum > 3) {
                        newMatrix[i][j] = 0;
//                        System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 最终死亡");
                    } else {
                        newMatrix[i][j] = 1;
//                        System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 最终存活");
                    }
                } else {
                    if (liveNum == 3) {
                        newMatrix[i][j] = 1;
//                        System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 最终存活");
                    } else {
                        newMatrix[i][j] = 0;
//                        System.out.println("(" + i + "," + j + ")-" + board[i][j] + " 最终死亡");
                    }
                }
            }
        }

        // 将新的矩阵复制进去
        for (int i = 0; i < rowLength; i++) {
            System.arraycopy(newMatrix[i], 0, board[i], 0, colLength);
        }
    }

}
