package com.wwj.likoute;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 */
public class LongestCommonPreFixTest {

    /*
        输入：strs = ["flower","flow","flight"]
        输出："fl"
     */

    @Test
    public void fun() {
//        String[] strs = new String[]{"flower", "flow", "flight"};
        String[] strs = new String[]{"dog", "racecar", "car"};

        String res = longestCommonPrefix(strs);

        System.out.println("result: " + res);
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int currentIndex = 0;
        int minLength = Integer.MAX_VALUE;
        for (String singleString : strs) {
            minLength = Math.min(minLength, singleString.length());
        }

        for (int i = 0; i < minLength; i++) {
            res = strs[0].substring(0, i + 1);
            boolean currentOk = true;
            for (String singString : strs) {
                if (!singString.startsWith(res)) {
                    currentOk = false;
                    break;
                }
            }

            if (!currentOk) {
                break;
            }
            currentIndex = i + 1;
        }

        if (currentIndex == 0) {
            return "";
        }

        return strs[0].substring(0, currentIndex);
    }
}
