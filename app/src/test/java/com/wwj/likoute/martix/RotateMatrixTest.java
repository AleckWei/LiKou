package com.wwj.likoute.martix;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AleckWei
 * @detail 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class RotateMatrixTest {

    /*
        输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        输出：[1,2,3,6,9,8,7,4,5]
     */

    @Test
    public void fun() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println(res);

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> resList = new LinkedList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        // 访问过的元素
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(visited[i], 0);
        }

        // 要访问的总数量
        int totalNum = row * col;

        // 当前的方向
        int currentDirection = 0;
        // 执行方向的数组，方向依次为右，下，左，上（符合顺时针的顺序）
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // 当前的x，y坐标
        int currentX = 0;
        int currentY = 0;
        while (resList.size() < totalNum) {
//            System.out.println("当前已添加元素：" + resList.size() + "个");

            if (visited[currentX][currentY] <= 0) {
//                System.out.println("(" + currentX + "," + currentY + ") - " + matrix[currentX][currentY] + "尚未添加过");

                // 当前坐标没访问过
                // 记录当前坐标已经访问
                visited[currentX][currentY]++;
                // 将当前数组记录进结果数组
                resList.add(matrix[currentX][currentY]);
            } else {
//                System.out.println("(" + currentX + "," + currentY + ") - " + matrix[currentX][currentY] + "已经被添加！");

                // 访问过该坐标的话，要倒退一次
                currentX -= direction[currentDirection][0];
                currentY -= direction[currentDirection][1];
                // 方向旋转一次
                currentDirection = (currentDirection + 1) % 4;
            }

            // 尝试获取下一步的坐标
            int nextX = currentX + direction[currentDirection][0];
            int nextY = currentY + direction[currentDirection][1];

            if (nextX >= row || nextY >= col || nextX < 0 || nextY < 0) {
                // 当前越界了，就需要换一个方向了
                currentDirection = (currentDirection + 1) % 4;

                currentX = currentX + direction[currentDirection][0];
                currentY = currentY + direction[currentDirection][1];
            } else {
                // 没有越界，则正确赋值
                currentX = nextX;
                currentY = nextY;
            }

//            System.out.println("获取的下一步下标：(" + currentX + "," + currentY + ")");
        }


        return resList;
    }

}
