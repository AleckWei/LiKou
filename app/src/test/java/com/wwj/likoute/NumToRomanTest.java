package com.wwj.likoute;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author AleckWei
 * @detail 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class NumToRomanTest {

    /*
        输入: num = 1994
        输出: "MCMXCIV"
        解释: M = 1000, CM = 900, XC = 90, IV = 4.
     */

    @Test
    public void fun() {
        int num = 60;
        String res = intToRoman(num);

        System.out.println(res);
    }

    private static final HashMap<Integer, String> mMatchMap;

    static {
        mMatchMap = new HashMap<>();
        mMatchMap.put(1, "I");
        mMatchMap.put(4, "IV");
        mMatchMap.put(5, "V");
        mMatchMap.put(9, "IX");
        mMatchMap.put(10, "X");
        mMatchMap.put(40, "XL");
        mMatchMap.put(50, "L");
        mMatchMap.put(90, "XC");
        mMatchMap.put(100, "C");
        mMatchMap.put(400, "CD");
        mMatchMap.put(500, "D");
        mMatchMap.put(900, "CM");
        mMatchMap.put(1000, "M");
    }

    public String intToRoman(int num) {
        // 当前10的指数
        int index = 0;
        // 结果字符串的组装
        StringBuilder res = new StringBuilder();

        while (num > 0) {
            // 取出最低位的数字
            int temp = num % 10;

            // 还原最低位数字代表的真实数值
            // 如 index == 0 时， currentPow = 1;
            // 如 index == 1 时， currentPow = 10;
            int currentPow = (int) Math.pow(10, index);
            temp = temp * currentPow;

            // 当前真实数值是否为特殊数值
            String currentRes = mMatchMap.get(temp);
            if (currentRes != null) {
                // 如果是特殊数值，即在res的前面进行插入
                res.insert(0, currentRes);
            } else {
                // 如果不是特殊字符，则要判断这个数字是否大于了这个所处区间的一半
                // 如80，此时index=1，大于了区间100的一半50
                int currentEdenHalf = (int) Math.pow(10, index + 1) >> 1;
                String currentPowStr = mMatchMap.get(currentPow);
                if (temp > currentEdenHalf) {
                    temp -= currentEdenHalf;
                    // 先把小于一半的部分补上
                    for (int i = 0; i < temp / currentPow; i++) {
                        res.insert(0, currentPowStr);
                    }
                    // 然后在前面补上区间一半的代表值
                    res.insert(0, mMatchMap.get(currentEdenHalf));
                } else {
                    for (int i = 0; i < temp / currentPow; i++) {
                        res.insert(0, currentPowStr);
                    }
                }
            }

            index++;
            num = num / 10;
        }


        return res.toString();
    }

}
