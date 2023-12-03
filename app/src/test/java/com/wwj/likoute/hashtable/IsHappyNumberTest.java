package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author AleckWei
 * @detail 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 */
public class IsHappyNumberTest {

    /*
        输入：n = 19
        输出：true
        解释：
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 02 = 1
     */

    @Test
    public void fun() {
//        int n = 19;
        int n = 2;
        boolean res = isHappy(n);

        System.out.println(res);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> resSet = new HashSet<>();
        while (n != 1 && !resSet.contains(n)) {
            resSet.add(n);
            n = getNum(n);
        }

        return n == 1;
    }

    private int getNum(int n) {
        int tempRes = 0;
        while (n != 0) {
            int index = n % 10;
            tempRes += Math.pow(index, 2);
            n = n / 10;
        }

        return tempRes;
    }

}
