package com.wwj.likoute;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author AleckWei
 * @detail 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class NStringConvertTest {
    /*
        输入：s = "A", numRows = 1
        输出："A"
     */

    @Test
    public void fun() {
//        String s = "A";
//        int numRows = 1;

//        String s = "PAYPALISHIRING";
//        int numRows = 4;
//        int numRows = 3;

        String s = "AB";
        int numRows = 1;

        String res = convert(s, numRows);
        System.out.println(res);
    }

    public String convert(String s, int numRows) {
        // 先把s拆分成对应矩阵（二维数组）

        // 生成一个numRows行的链表数组
        LinkedList<String>[] resConvert = new LinkedList[numRows];
        for (int i = 0; i < numRows; i++) {
            LinkedList<String> rowList = new LinkedList<>();
            resConvert[i] = rowList;
        }

        String[] splitArray = s.split("");
        int row = 0;
        int currentStep = 1;
        for (String currentStr : splitArray) {
            LinkedList<String> strings = resConvert[row];
            strings.add(currentStr);

            if (numRows == 1) {
                continue;
            }

            row += currentStep;
            if (row > numRows - 1) {
                currentStep = -1;
                row = row + currentStep - 1;
            } else if (row < 0) {
                currentStep = 1;
                row = row + currentStep + 1;
            }
        }

        // 然后对矩阵逐行遍历
        StringBuilder stringBuilder = new StringBuilder();
        for (LinkedList<String> stringList : resConvert) {
            for (String current : stringList) {
                stringBuilder.append(current);
            }
        }
        return stringBuilder.toString();
    }

}
