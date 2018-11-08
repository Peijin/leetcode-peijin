/*
Implement regular expression matching with support for '.' and '*'.

    '.' Matches any single character.
    '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
    bool isMatch(const char *s, const char *p)

    Some examples:
    isMatch("aa","a") → false
    isMatch("aa","aa") → true
    isMatch("aaa","aa") → false
    isMatch("aa", "a*") → true
    isMatch("aa", ".*") → true
    isMatch("ab", ".*") → true
    isMatch("aab", "c*a*b") → true
*/

package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class RegularExpressionMatching {
    public static void main(String args[]){
        RegularExpressionMatching match = new RegularExpressionMatching();
        System.out.println(match.isMatch("aab","c*a*b"));
        System.out.println(match.isMatch("",""));
        System.out.println(match.isMatch("",".*"));
        System.out.println(match.isMatch("",".*.*"));
        System.out.println(match.isMatch("a","."));
        System.out.println(match.isMatch("aaa","aaa"));
        System.out.println(match.isMatch("aaaab","a*b"));
        System.out.println(match.isMatch("aaab","a*b*"));
        System.out.println(match.isMatch("aaab","a*ab"));
        System.out.println(match.isMatch("abc","..."));
        System.out.println(match.isMatch("adgfa",".*gfa"));
        System.out.println(match.isMatch("trgf","t.*"));
        System.out.println(match.isMatch("trwgew",".*w"));
        System.out.println(match.isMatch("trwgew","tr.*w"));
        System.out.println(match.isMatch("aaa","ab*a*c*a"));

        System.out.println(match.isMatch("a",""));
        System.out.println(match.isMatch("aab","ab"));
        System.out.println(match.isMatch("aaab","c.*"));

    }

    /**
     * 2017.06.02 我写出了这份代码，并且非常清理内在的逻辑，特此证明
     * 能看懂的都是人才，也许过几天我自己也看不懂了。。。
     * 大致思路：建立二维数组，以resultMap[i+1][j+1]表示s到第i位为止，p到第j位为止，两个字符串是否匹配。把[0]留给空字符串
     * 数学归纳法，每对i,j是否匹配，由它们本身的值和它们前面的串是否匹配共同决定的。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;

        boolean resultMap[][] = new boolean[s.length() + 1][p.length() + 1];
        resultMap[0][0] = true;
        for(int pIndex = 0; pIndex < p.length(); pIndex++){
            for(int sIndex = -1; sIndex < s.length(); sIndex++){
                if(p.charAt(pIndex) == '*'){
                    int sBack = sIndex;
                    boolean backMatch = false;
                    while (sBack >= 0 && (p.charAt(pIndex - 1) == '.' || s.charAt(sBack) == p.charAt(pIndex - 1))) {
                        backMatch |= resultMap[sBack + 1][pIndex];
                        sBack--;
                    }
                    resultMap[sIndex + 1][pIndex + 1] = backMatch || (pIndex < 1 ? false: backMatch || (resultMap[sIndex + 1][pIndex - 1]));
                }else {
                    if(sIndex == -1) continue;
                    resultMap[sIndex + 1][pIndex + 1] = (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) && resultMap[sIndex][pIndex];
                }
            }
        }
        return resultMap[s.length()][p.length()];
    }

}
