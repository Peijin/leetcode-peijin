/*
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example:

    Input: "babad"

    Output: "bab"

    Note: "aba" is also a valid answer.
    Example:

    Input: "cbbd"

    Output: "bb"
*/
package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class LongestPalindromicSubstring {
    public String longestForCenter(String s, int centerLeft, int centerRight){
        while(centerLeft >= 0 && centerRight < s.length() && s.charAt(centerLeft) == s.charAt(centerRight)){
            centerLeft --;
            centerRight ++;
        }
        String subString = s.substring(centerLeft + 1, centerRight);
        return subString;
    }
    public String longestPalindrome(String s) {
        if(s == null || s == ""){
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0,1);

        for(int index = 0; index < s.length() - 1; index++){
            String tmp = longestForCenter(s, index, index);
            longest = longest.length() > tmp.length() ? longest : tmp;
            tmp = longestForCenter(s, index, index+1);
            longest = longest.length() > tmp.length() ? longest : tmp;
        }
        return longest;
    }
}
