package com.wwj.likoute;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 */
public class DispatchCandyTest {

    /*
    示例 1：
        输入：ratings = [1,0,2]
        输出：5
        解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     */
    @Test
    public void fun() {
//        int[] ratings = new int[]{1, 0, 2};
//        int[] ratings = new int[]{1, 2, 2};

        int[] ratings = new int[]{1, 3, 2, 2, 1};
        int res = candy(ratings);
        System.out.println(res);
    }

    // 左规则与右规则
    public int candy(int[] ratings) {
        int res = 0;

        int[] L = new int[ratings.length];
        int[] R = new int[ratings.length];

        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) {
                L[i] = 1;
            } else {
                if (ratings[i] > ratings[i - 1]) {
                    L[i] = L[i - 1] + 1;
                } else {
                    L[i] = 1;
                }
            }
        }

        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i == ratings.length - 1) {
                R[i] = 1;
            } else {
                if (ratings[i] > ratings[i + 1]) {
                    R[i] = R[i + 1] + 1;
                } else {
                    R[i] = 1;
                }
            }
        }

        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(L[i], R[i]);
        }

        return res;
    }

    public int candy1(int[] ratings) {
        int[] resArray = new int[ratings.length];
        int rating0 = ratings[0];
        int rating1 = ratings[1];
        if (rating0 >= rating1) {
            resArray[0] = 2;
            resArray[1] = 1;
        } else {
            resArray[0] = 1;
            resArray[1] = 2;
        }


        for (int i = 2; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                resArray[i] = resArray[i - 1] + 1;
            } else {
                resArray[i] = 1;
            }
        }

        int res = 0;
        for (int resItem : resArray) {
            res += resItem;
        }

        return res;
    }
}
