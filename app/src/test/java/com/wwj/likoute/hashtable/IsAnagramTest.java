package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AleckWei
 * @detail 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 */
public class IsAnagramTest {

    /*
        输入: s = "anagram", t = "nagaram"
        输出: true
     */

    @Test
    public void fun() {
//        String s = "anagram", t = "nagaram";
        String s = "rat", t = "car";
        boolean res = isAnagram(s, t);
        System.out.println(res);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        String[] sSplitArray = s.split("");
        String[] tSplitArray = t.split("");

        HashMap<String, Integer> sStrNumMap = new HashMap<>();
        HashMap<String, Integer> tStrNumMap = new HashMap<>();

        for (String sSingleStr : sSplitArray) {
            if (sStrNumMap.containsKey(sSingleStr)) {
                int num = sStrNumMap.get(sSingleStr);
                sStrNumMap.put(sSingleStr, num + 1);
            } else {
                sStrNumMap.put(sSingleStr, 1);
            }
        }

        for (String tSingleStr : tSplitArray) {
            if (tStrNumMap.containsKey(tSingleStr)) {
                int num = tStrNumMap.get(tSingleStr);
                tStrNumMap.put(tSingleStr, num + 1);
            } else {
                tStrNumMap.put(tSingleStr, 1);
            }
        }

        for (Map.Entry<String, Integer> sEntrySet : sStrNumMap.entrySet()) {
            String sSingleStr = sEntrySet.getKey();
            Integer sSingleNum = sEntrySet.getValue();

            if (!tStrNumMap.containsKey(sSingleStr)) {
                return false;
            } else {
                int sStrNumInTString = tStrNumMap.get(sSingleStr);
                if (sStrNumInTString != sSingleNum) {
                    return false;
                }

                tStrNumMap.remove(sSingleStr);
            }
        }

        return tStrNumMap.size() <= 0;
    }

}
