package com.wwj.likoute.hashtable;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @author AleckWei
 * @detail 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class GroupAnagramsTest {

    /*
        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */

    @Test
    public void fun() {
//        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = new String[]{""};

        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> reflectMap = new HashMap<>();
        List<List<String>> res = new LinkedList<>();

        for (String str : strs) {
            String groupString = getStringGroup(str);

            List<String> strList;
            if (reflectMap.containsKey(groupString)) {
                strList = reflectMap.get(groupString);
            } else {
                strList = new LinkedList<>();
            }

            strList.add(str);
            reflectMap.put(groupString, strList);
        }

        for (Map.Entry<String, List<String>> listEntry : reflectMap.entrySet()) {
            res.add(listEntry.getValue());
        }

        return res;
    }

    private String getStringGroup(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        StringBuilder res = new StringBuilder();
        for (char c : chars) {
            res.append(c);
        }

        return res.toString();
    }

}
