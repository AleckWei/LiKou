package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author AleckWei
 * @detail 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，
 * 满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class ContainsNearbyDuplicateTest {

    /*
        输入：nums = [1,2,3,1], k = 3
        输出：true
     */

    @Test
    public void fun() {
//        int[] nums = new int[]{1, 2, 3, 1};
//        int k = 3;

//        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
//        int k = 2;

        int[] nums = new int[]{1, 0, 1, 1};
        int k = 1;

        boolean res = containsNearbyDuplicate(nums, k);
        System.out.println(res);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> currentIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (currentIndexMap.containsKey(nums[i])) {
                List<Integer> indexList = currentIndexMap.get(nums[i]);
                for (Integer beforeIndex : indexList) {
                    if (Math.abs(i - beforeIndex) <= k) {
                        return true;
                    }
                }
                indexList.add(i);
                currentIndexMap.put(nums[i], indexList);
            } else {
                ArrayList<Integer> indexList = new ArrayList<>();
                indexList.add(i);

                currentIndexMap.put(nums[i], indexList);
            }
        }


        return false;
    }

}
