/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
*/

package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result = 0;
        do{
            int newResult = result * 10 + x % 10;
            if((newResult - x % 10) / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }while(x != 0);

        return result;
    }

    public static void main(String args[]){
        ReverseInteger ri = new ReverseInteger();
        System.out.println(Integer.MAX_VALUE);
    }
}
