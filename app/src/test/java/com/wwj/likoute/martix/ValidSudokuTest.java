package com.wwj.likoute.martix;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author AleckWei
 * @detial 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 */
public class ValidSudokuTest {

    /*
    输入：board =
        [["5","3",".",".","7",".",".",".","."]
        ,["6",".",".","1","9","5",".",".","."]
        ,[".","9","8",".",".",".",".","6","."]
        ,["8",".",".",".","6",".",".",".","3"]
        ,["4",".",".","8",".","3",".",".","1"]
        ,["7",".",".",".","2",".",".",".","6"]
        ,[".","6",".",".",".",".","2","8","."]
        ,[".",".",".","4","1","9",".",".","5"]
        ,[".",".",".",".","8",".",".","7","9"]]
        输出：true
     */

    @Test
    public void fun() {
        char[][] board = new char[][]{{"5".charAt(0), "3".charAt(0), ".".charAt(0), ".".charAt(0), "7".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0)}, {"6".charAt(0), ".".charAt(0), ".".charAt(0), "1".charAt(0), "9".charAt(0), "5".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0)}, {".".charAt(0), "9".charAt(0), "8".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "6".charAt(0), ".".charAt(0)}, {"8".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "6".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "3".charAt(0)}, {"4".charAt(0), ".".charAt(0), ".".charAt(0), "8".charAt(0), ".".charAt(0), "3".charAt(0), ".".charAt(0), ".".charAt(0), "1".charAt(0)}, {"7".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "2".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "6".charAt(0)}, {".".charAt(0), "6".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "2".charAt(0), "8".charAt(0), ".".charAt(0)}, {".".charAt(0), ".".charAt(0), ".".charAt(0), "4".charAt(0), "1".charAt(0), "9".charAt(0), ".".charAt(0), ".".charAt(0), "5".charAt(0)}, {".".charAt(0), ".".charAt(0), ".".charAt(0), ".".charAt(0), "8".charAt(0), ".".charAt(0), ".".charAt(0), "7".charAt(0), "9".charAt(0)}};

        boolean validSudoku = isValidSudoku(board);

        System.out.println(validSudoku);

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> singleItemCharSet = new HashSet<>(9);
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][][] item = new int[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    int currentNum = currentChar - '0' - 1;
                    // 行
                    row[i][currentNum]++;

                    // 列
                    col[j][currentNum]++;

                    // 一宫内
                    item[i / 3][j / 3][currentNum]++;

                    if (row[i][currentNum] > 1 || col[j][currentNum] > 1 || item[i / 3][j / 3][currentNum] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
