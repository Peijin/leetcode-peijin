/*
 * Write a function to find the longest common prefix string amongst an array of strings.
 */

package com.peijin.leetcode.algorithm;

/**
 * Created by peijin.zhangpj on 2017/6/5.
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        int commonIndex = 0;
        try{
            while(true){
                char reference = strs[0].charAt(commonIndex);
                for(int strIndex = 1; strIndex < strs.length; strIndex++){
                    if(reference != strs[strIndex].charAt(commonIndex)){
                        throw new Exception();
                    }
                }
                commonIndex++;
            }

        }catch (Exception e){
            //e.printStackTrace();
        }
        return strs[0].substring(0, commonIndex);
    }

    public static void main(String[] args){
        System.out.println("aaa".substring(0, 0));
    }

}
