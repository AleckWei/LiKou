package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author AleckWei
 * @detail 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSumTest {

    /*
        输入：nums = [2,7,11,15], target = 9
        输出：[0,1]
        解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */

    @Test
    public void fun() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numAndIndexMap.containsKey(target - nums[i])) {
                return new int[]{numAndIndexMap.get(target - nums[i]), i};
            }

            numAndIndexMap.put(nums[i], i);
        }

        return new int[2];
    }

}
