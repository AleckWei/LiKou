package com.wwj.likoute.interval;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author AleckWei
 * @detail 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class SummaryRangesTest {

    /*
        输入：nums = [0,1,2,4,5,7]
        输出：["0->2","4->5","7"]
        解释：区间范围是：
        [0,2] --> "0->2"
        [4,5] --> "4->5"
        [7,7] --> "7"
     */
    @Test
    public void fun() {
//        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};

        List<String> res = summaryRanges(nums);
        System.out.println(res);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        }

        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                // 证明连续
                endIndex = i;
            } else {
                // 证明连续已经断开了
                int startNum = nums[startIndex];
                if (endIndex <= startIndex) {
                    // 证明这个连续区间只有自己
                    res.add(String.valueOf(startNum));
                    endIndex = startIndex;
                } else {
                    int endNum = nums[endIndex];
                    res.add(startNum + "->" + endNum);
                }

                // 启动下标移动到下一个数字
                startIndex = i;
            }
        }

        if (startIndex >= endIndex) {
            res.add(nums[startIndex] + "");
        } else {
            res.add(nums[startIndex] + "->" + nums[endIndex]);
        }

        return res;
    }

}
