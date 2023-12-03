package com.wwj.likoute;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中
 * 找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class FindFirstMatchIndexTest {

    /*
        示例 1：
        输入：haystack = "sadbutsad", needle = "sad"
        输出：0
        解释："sad" 在下标 0 和 6 处匹配。
        第一个匹配项的下标是 0 ，所以返回 0 。
     */

    @Test
    public void fun() {
//        String haystack = "sadbutsad", needle = "sad";
//        String haystack = "leetcode", needle = "leeto";
//        String haystack = "hello", needle = "ll";
        String haystack = "abc", needle = "c";

        int res = strStr(haystack, needle);

        System.out.println(res);
    }

    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String strInHay = haystack.substring(i, i + needle.length());
            if (needle.equals(strInHay)) {
                res = i;
                break;
            }
        }


        return res;
    }

}
