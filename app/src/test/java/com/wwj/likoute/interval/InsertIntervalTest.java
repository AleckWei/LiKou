package com.wwj.likoute.interval;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WWJ
 * @detail: 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * @date: 2023/12/6 15:51
 */
public class InsertIntervalTest {

    /*
        输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
        输出：[[1,5],[6,9]]
     */

    @Test
    public void fun() {
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        // [[1, 5], [6, 9]]

//        int[][] intervals = new int[][]{{1, 2}, {3, 4}, {7, 10}, {12, 16}};
//        int[] newInterval = new int[]{6, 13};
        // [[1,2],[3,4],[6,11],[12,16]]
        // [[1,2],[3,10],[12,16]]

//        int[][] intervals = new int[][]{};
//        int[] newInterval = new int[]{5, 7};
        // [[5,7]]

//        int[][] intervals = new int[][]{{5, 7}};
//        int[] newInterval = new int[]{0, 4};
        // [[1, 5], [6, 8]]

        int[][] res = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        int newLeft = newInterval[0];
        int newRight = newInterval[1];

        List<int[]> resList = new ArrayList<>(Arrays.asList(intervals));

        int insertIndex = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newLeft) {
                insertIndex = i;
                break;
            }
        }

        int[] nextInterval = intervals[insertIndex];
        int nextLeft = nextInterval[0];
        if (newRight >= nextLeft) {
            // 证明要往后合并
            int lastLeft = insertIndex;
            for (int i = insertIndex; i < intervals.length; i++) {
                if (newRight <= intervals[i][1]) {
                    lastLeft = i;
                    break;
                }
            }

            newInterval[1] = intervals[lastLeft][1];

            int i = insertIndex;
            while (i <= lastLeft) {
                i++;
                resList.remove(insertIndex);
            }
        }

        resList.add(insertIndex, newInterval);


        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int newLeft = newInterval[0];
            int newRight = newInterval[1];
            boolean placed = false;
            List<int[]> ansList = new ArrayList<>();
            for (int[] interval : intervals) {
                int currentLeft = interval[0];
                int currentRight = interval[1];
                if (newRight < currentLeft) {
                    // 在插入区间的右侧且无交集
                    if (!placed) {
                        ansList.add(newInterval);
                        placed = true;
                    }
                    ansList.add(interval);
                } else if (currentRight < newLeft) {
                    // 在插入区间的左侧且无交集
                    ansList.add(interval);
                } else {
                    // 与插入区间有交集，计算它们的并集
                    newLeft = Math.min(newLeft, currentLeft);
                    newRight = Math.max(newRight, currentRight);
                }
            }
            if (!placed) {
                ansList.add(newInterval);
            }
            int[][] ans = new int[ansList.size()][2];
            for (int i = 0; i < ansList.size(); ++i) {
                ans[i] = ansList.get(i);
            }
            return ans;
        }
    }


}
