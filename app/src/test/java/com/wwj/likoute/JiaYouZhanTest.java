package com.wwj.likoute;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 */
public class JiaYouZhanTest {

    /*
    示例 1:
        输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        输出: 3
        解释:
        从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        因此，3 可为起始索引。
     */

    @Test
    public void fun() {
        // 示例1
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

        // 示例2
//        int[] gas = new int[]{2, 3, 4};
//        int[] cost = new int[]{3, 4, 3};

        int res = canCompleteCircuit(gas, cost);

        System.out.println(res);

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int totalGas = 0, totalCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                totalGas += gas[j];
                totalCost += cost[j];
                if (totalCost > totalGas) {
                    break;
                }
                cnt++;
            }

            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

    // 运行超时
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int res = -1;

        // 当前汽车中的汽油
        int currentGas = 0;
        // 当前加油站到下一站需要的油耗
        int currentCost;

        // 当前能够到达的终点的下标
        int currentEndIndex = 0;
        // 当前启动的下标
        int startIndex = 0;
        // 当前的加油站的数量
        int length = gas.length;

        // 退出循环的条件： currentGas < 当前步骤的cost
        while (startIndex < gas.length) {
            currentGas += gas[currentEndIndex];
            currentCost = cost[currentEndIndex];
            if (currentGas < currentCost) {
                // 当前启动运行至此满足不了循环了
                // 启动下标+1
                startIndex++;
                // 当前可达到的下标和启动下标相同
                currentEndIndex = startIndex;
                // 油量置空
                currentGas = 0;
            } else {
                // 维护一下油量
                currentGas -= currentCost;
                // 如果此时能够满足
                // 则可到达的下标+1
                currentEndIndex++;
                // 当endIndex超出长度时取余
                currentEndIndex = currentEndIndex % length;

                if (currentEndIndex == startIndex) {
                    // 若此时恰好endIndex能到达start
                    // 证明此时油量还有剩余也走完了一圈
                    res = currentEndIndex;
                    break;
                }
            }
        }

        return res;
    }
}
