package com.wwj.likoute;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author AleckWei
 * @detail 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2]
 * ，则 1 <= index1 < index2 <= numbers.length 。
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class GetTwoNumTotalTest {

    /*
        输入：numbers = [2,7,11,15], target = 9
        输出：[1,2]
        解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
     */

    @Test
    public void fun() {
//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;

//        int[] nums = new int[]{2, 3, 4};
//        int target = 6;

        int[] nums = new int[]{-1, 0};
        int target = -1;

        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public int[] twoSum(int[] numbers, int target) {
        // 记录数组中有哪些可用数据，key为数据本身，value为他们的下标
        HashMap<Integer, Integer> mIndexMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            mIndexMap.put(number, i);
        }

        int[] res = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            int otherNum = target - currentNum;

            Integer otherNumIndex = mIndexMap.get(otherNum);
            if (otherNumIndex != null) {
                if (otherNumIndex != i) {
                    res[0] = i + 1;
                    res[1] = otherNumIndex + 1;
                    break;
                }
            }
        }

        return res;
    }
}
