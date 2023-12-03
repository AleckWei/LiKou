package com.wwj.likoute.hashtable;

import org.junit.Test;

/**
 * @author AleckWei
 * @detail 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 */
public class CanConstructTest {

    /*
        输入：ransomNote = "a", magazine = "b"
        输出：false
     */
    @Test
    public void fun() {
//        String ransomNote = "a", magazine = "b";
//        String ransomNote = "aa", magazine = "ab";
//        String ransomNote = "aa", magazine = "aab";

        String ransomNote = "bg", magazine = "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj";
        boolean res = canConstruct(ransomNote, magazine);
        System.out.println(res);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        String[] splitStrArray = magazine.split("");
        for (String singleStr : splitStrArray) {
            int indexOfSingleStr = ransomNote.indexOf(singleStr);
            if (indexOfSingleStr == -1) {
                continue;
            }

            ransomNote = ransomNote.substring(0, indexOfSingleStr) + ransomNote.substring(indexOfSingleStr + 1);

            if (ransomNote.length() == 0) {
                break;
            }
        }

        return ransomNote.length() <= 0;
    }

}
