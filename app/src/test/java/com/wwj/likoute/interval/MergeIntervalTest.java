package com.wwj.likoute.interval;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author WWJ
 * @detail: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 * @date: 2023/12/4 16:57
 */
public class MergeIntervalTest {

    /*
        输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        输出：[[1,6],[8,10],[15,18]]
        解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     */

    @Test
    public void fun() {
//        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 4}, {4, 5}};
        int[][] intervals = new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] res = merge(intervals);

        System.out.println("结果: " + Arrays.deepToString(res));
    }

    public int[][] merge(int[][] intervals) {
        // 先按照区间起点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println("排序: " + Arrays.deepToString(intervals));

        List<int[]> resList = new LinkedList<>();
        resList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int currentLeft = intervals[i][0];
            int currentRight = intervals[i][1];

            int[] lastInterval = resList.get(resList.size() - 1);
            int lastIntervalLeft = lastInterval[0];
            int lastIntervalRight = lastInterval[1];
            if (currentLeft > lastIntervalRight) {
                // 证明最后一个区间也满足不了这个新的区间
                resList.add(intervals[i]);
            } else {
                if (currentLeft < lastIntervalLeft) {
                    lastInterval[0] = currentLeft;
                }

                if (currentRight > lastIntervalRight) {
                    lastInterval[1] = currentRight;
                }

                resList.set(resList.size() - 1, lastInterval);
            }

        }


        return resList.toArray(new int[resList.size()][2]);
    }

    private void bubbleSort(int[][] intervals) {
        int length = intervals.length;
        boolean swapped;
        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public int[][] merge1(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[1][1];
        }

        List<int[]> resList = new ArrayList<>();
        resList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int left = interval[0];
            int right = interval[1];

            for (int j = 0; j < resList.size(); j++) {
                int[] ints = resList.get(j);
                int singleResLeft = ints[0];
                int singleResRight = ints[1];

                if (right < singleResLeft) {
                    // 证明区间在该已有集合的左侧
                    resList.add(interval);
                } else if (left <= singleResRight) {
                    // 证明区间被捕获
                    if (right >= singleResRight) {
                        // 右区间扩大
                        ints[1] = right;
                        resList.set(j, ints);
                    } else {
                        // 证明为子集，不需要改动原本的区间
                        System.out.println("[" + left + "," + right + "] 是 [" + singleResLeft + "," + singleResRight + "]的子集");
                    }
                    break;
                } else {
                    // 证明区间在该已有集合的右侧
                    resList.add(interval);
                }
            }
        }

//        System.out.println(resList);
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }

        return res;
    }

}
