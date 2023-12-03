package com.wwj.likoute;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class LastWordLengthTest {

    /*
        输入：s = "Hello World"
        输出：5
        解释：最后一个单词是“World”，长度为5。
     */

    @Test
    public void fun() {
//        String s = "Hello World";
        String s = "   fly me   to   the moon  ";
        int res = lengthOfLastWord(s);

        System.out.println(res);
    }

    public int lengthOfLastWord(String s) {
        String[] strArray = s.split(" ");
        return strArray[strArray.length - 1].length();
    }

}
