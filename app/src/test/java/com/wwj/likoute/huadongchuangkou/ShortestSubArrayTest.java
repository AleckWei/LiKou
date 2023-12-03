package com.wwj.likoute.huadongchuangkou;

import org.junit.Test;

/**
 * @author AleckWei
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其总和大于等于 target 的长度最小的
 * 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class ShortestSubArrayTest {

    /*
        输入：target = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */

    @Test
    public void fun() {
//        int target = 7;
//        int[] nums = new int[]{2, 3, 1, 2, 4, 3};

//        int target = 11;
//        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

//        int target = 4;
//        int[] nums = new int[]{1, 4, 4};

        int target = 6;
        int[] nums = new int[]{10, 2, 3};

        int res = minSubArrayLen(target, nums);
        System.out.println(res);
    }

    /**
     * 滑动窗口算法
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int sum = 0;
        int lestLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                sum -= nums[left];
                lestLength = Math.min(right - left + 1, lestLength);

                left++;
            }
            right++;
        }

        return lestLength == Integer.MAX_VALUE ? 0 : lestLength;
    }

    /**
     * 时间复杂度为O(n^2)，绝对超时
     */
    public int minSubArrayLenOutOfTime(int target, int[] nums) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    length = Math.min(length, j - i + 1);
                    break;
                }
            }
        }

        if (length == Integer.MAX_VALUE) {
            return 0;
        }

        return length;
    }

}
