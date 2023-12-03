package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author AleckWei
 * @detail 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class IfSameConstructTest {

    /*
        输入：s = "egg", t = "add"
        输出：true
     */

    @Test
    public void fun() {
//        String s = "egg", t = "add";
//        String s = "foo", t = "bar";
//        String s = "paper", t = "title";
        String s = "badc", t = "bada";
        boolean res = isIsomorphic(s, t);

        System.out.println(res);
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<String, String> s2tReflectMap = new HashMap<>();
        HashMap<String, String> t2sReflectMap = new HashMap<>();

        String[] splitSArray = s.split("");
        String[] splitTArray = t.split("");

        for (int i = 0; i < splitSArray.length; i++) {
            String sSingleStr = splitSArray[i];
            String tSingleStr = splitTArray[i];

            if (s2tReflectMap.containsKey(sSingleStr)) {
                String sReflectStr = s2tReflectMap.get(sSingleStr);
                if (!sReflectStr.equals(tSingleStr)) {
                    return false;
                }
            } else {
                s2tReflectMap.put(sSingleStr, tSingleStr);
            }

            if (t2sReflectMap.containsKey(tSingleStr)) {
                String tReflectStr = t2sReflectMap.get(tSingleStr);
                if (!tReflectStr.equals(sSingleStr)) {
                    return false;
                }
            } else {
                t2sReflectMap.put(tSingleStr, sSingleStr);
            }
        }
        return true;
    }

    public boolean isIsomorphicError(String s, String t) {
        HashMap<String, String> struct = new HashMap<>();
        int currentStep = 0;

        StringBuilder sStruct = new StringBuilder();
        String[] sStrSplitArray = s.split("");
        for (String sSingleStr : sStrSplitArray) {
            if (struct.containsKey(sSingleStr)) {
                String structStr = struct.get(sSingleStr);
                sStruct.append(structStr);
            } else {
                sStruct.append(currentStep);
                struct.put(sSingleStr, String.valueOf(currentStep));
                currentStep++;
            }
        }

        currentStep = 0;
        struct.clear();
        StringBuilder tStruct = new StringBuilder();
        String[] tStrSplitArray = t.split("");
        for (String tSingleStr : tStrSplitArray) {
            if (struct.containsKey(tSingleStr)) {
                String structStr = struct.get(tSingleStr);
                tStruct.append(structStr);
            } else {
                tStruct.append(currentStep);
                struct.put(tSingleStr, String.valueOf(currentStep));
                currentStep++;
            }
        }

        String sStructStr = sStruct.toString();
        String tStructStr = tStruct.toString();

//        System.out.println("s的结构：" + sStructStr + ", t的结构：" + tStructStr);

        return tStructStr.equals(sStructStr);
    }

}
