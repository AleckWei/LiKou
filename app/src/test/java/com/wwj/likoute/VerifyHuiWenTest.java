package com.wwj.likoute;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author AleckWei
 * @detail 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
 * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class VerifyHuiWenTest {
    /*
        输入: s = "A man, a plan, a canal: Panama"
        输出：true
        解释："amanaplanacanalpanama" 是回文串。
     */

    @Test
    public void fun() {
//        String s = "A man, a plan, a canal: Panama";
//        String s = "race a car";
        String s = "0P";
        boolean res = isPalindrome(s);

        System.out.println(res);
    }

    public boolean isPalindrome(String s) {
        String[] stringArray = s.split("");
        ArrayList<String> resList = new ArrayList<>();

        for (String singleStr : stringArray) {

            try {
                // 证明是数字
                int numStr = Integer.parseInt(singleStr);
                resList.add(String.valueOf(numStr));
            } catch (Exception e) {
                // 证明不是数字
                String lowerCase = singleStr.toLowerCase(Locale.ROOT);
                if (lowerCase.charAt(0) >= 'a' && lowerCase.charAt(0) <= 'z') {
                    resList.add(lowerCase);
                }
            }
        }

        if (resList.size() == 0) {
            return true;
        }

        boolean res = true;
        for (int i = 0; i < resList.size() / 2; i++) {
            if (!resList.get(i).equals(resList.get(resList.size() - i - 1))) {
                res = false;
                break;
            }
        }

        return res;
    }
}
