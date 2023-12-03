package com.wwj.likoute.martix;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author AleckWei
 * @detail 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class SetMatrixZeroTest {

    /*
        输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        输出：[[1,0,1],[0,0,0],[1,0,1]]
     */

    @Test
    public void fun() {
//        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] rowArray = new boolean[row];
        boolean[] colArray = new boolean[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowArray[i] = true;
                    colArray[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowArray[i] || colArray[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
