package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/5.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] fromMap = new int[128];
        int[] toMap = new int[128];
        // 下面是基础方法
        //for(int index = 0; index < s.length(); index ++){
        //    int from = s.charAt(index);
        //    int to = t.charAt(index);
        //    if(fromMap[from] == 0 && toMap[to] == 0){
        //        fromMap[from] = to;
        //        toMap[to] = from;
        //        continue;
        //    }
        //
        //    if(fromMap[from] != to || toMap[to] != from)
        //        return false;
        //}
        return true;
    }

    public static void main(String[] args){
        System.out.println(isIsomorphic("aa", "ab"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
