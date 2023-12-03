package com.wwj.likoute.hashtable;


import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author AleckWei
 * @detail 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutive {

    /*
        输入：nums = [100,4,200,1,3,2]
        输出：4
        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */

    @Test
    public void fun() {
//        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
//        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
//        int[] nums = new int[1];
        int[] nums = new int[]{1, 2, 0, 1};

        int res = longestConsecutive(nums);

        System.out.println(res);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        // 去重
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int[] newNums = new int[numSet.size()];
        int k = 0;
        for (Integer integer : numSet) {
            newNums[k] = integer;
            k++;
        }


        Arrays.sort(newNums);

        int startIndex = 0;
        int endIndex = 0;
        int maxLength = -1;
        for (int i = 0; i < newNums.length - 1; i++) {
            if (newNums[i] + 1 == newNums[i + 1]) {
                endIndex = i + 1;
            } else {
                maxLength = Math.max(endIndex - startIndex + 1, maxLength);
                startIndex = i + 1;
            }
        }

        return Math.max(endIndex - startIndex + 1, maxLength);
    }

}
