/*
Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int currentStart = 0;
        int longest = 1;
        int currentCount = 1;
        for(int index = 1; index < s.length(); index++){

            int indexInSubstring = s.substring(currentStart, index).indexOf(s.charAt(index));
            if(indexInSubstring >= 0){
                currentStart = currentStart + indexInSubstring + 1;
            }
            currentCount = index - currentStart + 1;
            longest = currentCount > longest ? currentCount : longest;
        }
        return longest;
    }
}
