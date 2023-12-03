package com.wwj.likoute;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author AleckWei
 * @detail 给你一个整数数组 nums ，
 * 判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 */
public class ThreeNumSumTest {

    /*
        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
     */

    @Test
    public void fun() {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{0, 1, 1};

        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 还是用双指针的思想去解
     *
     * @param nums 给到的数据
     * @return 返回三元之和的数组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        // 先排序
        Arrays.sort(nums);
        // 得到 [-4, -1, -1, 0, 1, 2];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 该元素和上一个元素重复了，没必要继续比较匹配了
                continue;
            }
            int firstNum = nums[i];

            // 第三重指针（即双指针的右指针）
            int third = nums.length - 1;

            // 第二层循环
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // 同样的，和上一个重复了也不要比较了
                    continue;
                }

                int secondNum = nums[j];
                while (j < third && (firstNum + secondNum + nums[third]) > 0) {
                    third--;
                }

                if (j == third) {
                    break;
                }

                if (nums[third] + secondNum + firstNum == 0) {
                    LinkedList<Integer> singleAns = new LinkedList<>();
                    singleAns.add(firstNum);
                    singleAns.add(secondNum);
                    singleAns.add(nums[third]);

                    res.add(singleAns);
                }
            }
        }
        return res;
    }


}
