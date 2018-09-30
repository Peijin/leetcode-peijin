/**
 Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

 Return any permutation of A that maximizes its advantage with respect to B.



 Example 1:

 Input: A = [2,7,11,15], B = [1,10,4,11]
 Output: [2,11,7,15]
 Example 2:

 Input: A = [12,24,8,32], B = [13,25,32,11]
 Output: [24,32,8,12]
 */
package com.peijin.leetcode.algorithm.doing;
//[2,7,11,15]
//[1,10,4,11]

import java.util.Arrays;

/**
 * TODO ¿‡√Ë ˆ
 *
 * @author peijin.zhangpj
 * @version AdvantageShuffle.java, v 0.1 2018/9/12 16:58
 */
public class AdvantageShuffle {

    public static void main(String args[]){
        AdvantageShuffle as = new AdvantageShuffle();
        int[] A = new int[]{1,2,3,4,1,1,1};
        int[] B = new int[]{2,3,4,5,1,1,1};

        System.out.println(Arrays.toString(as.advantageCount(A, B)));
    }

    public int[] advantageCount(int[] A, int[] B) {
        for(int i = 0; i < B.length - 1; i++){
            for(int j = i + 1; j < A.length; j++){
                if ((A[i] <= B[i] && A[j] > B[i] )
                        || ( A[i] <= B[i] && A[j] < A[i])
                        || (A[j] < A[i] && A[j] > B[i])) {
                    
                }

            }
        }
        return A;
    }
}
