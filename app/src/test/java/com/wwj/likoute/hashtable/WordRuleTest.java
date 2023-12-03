package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author AleckWei
 * @detail 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class WordRuleTest {

    /*
        输入: pattern = "abba", s = "dog cat cat dog"
        输出: true
     */

    @Test
    public void fun() {
//        String pattern = "abba", s = "dog cat cat dog";
//        String pattern = "abba", s = "dog cat cat fish";
        String pattern = "abba", s = "dog dog dog dog";
        boolean res = wordPattern(pattern, s);
        System.out.println(res);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] pattenSplitArray = pattern.split("");
        String[] sSplitArray = s.split(" ");

        if (pattenSplitArray.length != sSplitArray.length) {
            return false;
        }

        HashMap<String, String> patternToSReflectMap = new HashMap<>();
        HashMap<String, String> sToPatternReflectMap = new HashMap<>();


        for (int i = 0; i < pattenSplitArray.length; i++) {
            String singlePatternStr = pattenSplitArray[i];
            String singleSStr = sSplitArray[i];

            if (patternToSReflectMap.containsKey(singlePatternStr)) {
                String patternToSStr = patternToSReflectMap.get(singlePatternStr);
                if (!patternToSStr.equals(singleSStr)) {
                    return false;
                }
            } else {
                patternToSReflectMap.put(singlePatternStr, singleSStr);
            }

            if (sToPatternReflectMap.containsKey(singleSStr)) {
                String sToPatternStr = sToPatternReflectMap.get(singleSStr);
                if (!sToPatternStr.equals(singlePatternStr)) {
                    return false;
                }
            } else {
                sToPatternReflectMap.put(singleSStr, singlePatternStr);
            }
        }

        return true;
    }

}
