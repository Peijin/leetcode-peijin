/*
Implement atoi to convert a string to an integer.

    Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

    Update (2015-02-10):
    The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

    spoilers alert... click to show requirements for atoi.
*/
package com.peijin.leetcode.algorithm.done;
/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class StringtoInteger {
    public int atoi(String str) {
        if(str == null || str.isEmpty()) {
            return 0;
        }
        int result = 0;
        boolean positive = true;
        boolean hasStarted = false;
        for(int index = 0; index < str.length(); index++){
            char currentChar = str.charAt(index);

            if(currentChar == '-'){
                if(hasStarted) {
                    break;
                }
                positive = false;
                hasStarted = true;
                continue;
            }
            if(currentChar == '+'){
                if(hasStarted) {
                    break;
                }
                positive = true;
                hasStarted = true;
                continue;
            }
            if((currentChar >= '0' && currentChar <= '9')){
                //
                if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && Integer.parseInt(String.valueOf(currentChar)) > (Integer.MAX_VALUE % 10))){
                    return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + Integer.parseInt(String.valueOf(currentChar));
                hasStarted = true;
                continue;
            }
            if(currentChar != ' ' || hasStarted){
                break;
            }
        }
        return positive ? result : 0 - result;
    }
}
