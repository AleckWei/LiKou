package com.wwj.likoute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author AleckWei
 * @detail 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class TakeMostWaterTest {

    /*
        输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
        贪心？
     */

    @Test
    public void fun() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
//        int[] height = new int[]{1, 1};

        int res = maxArea(height);
        System.out.println(res);
    }

    /**
     * 使用双指针思路解这题
     *
     * @param height 记录着每块板子高低的数组
     * @return 这个数组中可以装的最大的水的容量
     */
    public int maxArea(int[] height) {
        int res = -1;
        int left = 0;
        int right = height.length - 1;

        // 当左右指针相等时退出
        while (left < right) {
            // 有效高度
            int validHeight = Math.min(height[left], height[right]);
            // 此时宽度
            int width = right - left;
            // 此时盛水量
            int water = validHeight * width;
            // 记录最大盛水量
            res = Math.max(res, water);

            // 移动指针
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    /**
     * 时间复杂度为O(n^2)，数据量大时明显超时了
     */
    public int maxAreaOutOfTime(int[] height) {
        ArrayList<PackNumIndex> list = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            PackNumIndex packNumIndex = new PackNumIndex();
            packNumIndex.value = height[i];
            packNumIndex.index = i;

            list.add(packNumIndex);
        }

        Collections.sort(list, new Comparator<PackNumIndex>() {
            @Override
            public int compare(PackNumIndex o1, PackNumIndex o2) {
                return o2.value - o1.value;
            }
        });

        int res = -1;
        int length = list.size();
        if (length > 100) {
            length = length >> 1;
        }

        for (int i = 0; i < length; i++) {
            PackNumIndex firstPackNum = list.get(i);
            int firstHeight = firstPackNum.value;
            int firstIndex = firstPackNum.index;
            for (int j = i + 1; j < length; j++) {
                PackNumIndex secondPackNum = list.get(j);
                int secondHeight = secondPackNum.value;
                int secondIndex = secondPackNum.index;

                int validHeight = Math.min(firstHeight, secondHeight);
                int validWidth = Math.abs(firstIndex - secondIndex);

                res = Math.max(validHeight * validWidth, res);
            }
        }

        return res;
    }

    private static class PackNumIndex {
        int value;
        int index;
    }

}
