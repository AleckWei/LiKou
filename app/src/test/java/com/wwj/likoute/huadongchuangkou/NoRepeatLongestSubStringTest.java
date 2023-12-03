package com.wwj.likoute.huadongchuangkou;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class NoRepeatLongestSubStringTest {
    /*
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     */

    @Test
    public void fun() {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "a";
//        String s = " ";
        String s = "au";

        int res = lengthOfLongestSubstring(s);

        System.out.println(res);
    }

    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }

        if (s.length() <= 1) {
            return 1;
        }

        int left = 0, right = 0;
        int res = -1;
        String subStr;
        while (right < s.length()) {
            subStr = s.substring(left, right);
            String nextStr = s.substring(right, right + 1);

            if (!subStr.contains(nextStr)) {
                res = Math.max(res, right - left + 1);
            }

            while (subStr.contains(nextStr)) {
                subStr = subStr.substring(1);
                left++;
            }
            right++;
        }

        return res == -1 ? 0 : res;
    }

}
