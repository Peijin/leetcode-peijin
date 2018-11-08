/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

*/

package com.peijin.leetcode.algorithm.done;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(nRows == 1) {
            return s;
        }

        int nCols = (nRows - 2 + 1) * (s.length() / (nRows + nRows - 2) + 1);

        char[][] paper = new char[nCols][nRows];
        char[] str = s.toCharArray();
        int pr = 0, pc = 0;
        boolean direction = false;

        for(char c : str){
            paper[pc][pr] = c;

            if(pr == 0 || pr == nRows - 1){
                direction = !direction;
            }

            if(direction){
                pr++;
            }else{
                pr--;
                pc++;
            }
        }
        char[] rtArray = new char[s.length()];
        int index = 0;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                char current = paper[j][i];
                if(current != 0){
                    rtArray[index] = current;
                    index ++;
                }
            }
        }

        return new String(rtArray);
    }
}
