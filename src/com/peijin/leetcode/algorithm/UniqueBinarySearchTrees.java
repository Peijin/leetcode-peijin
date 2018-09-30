/**
 Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n
 */
package com.peijin.leetcode.algorithm;

/**
 * TODO ¿‡√Ë ˆ
 *
 * @author peijin.zhangpj
 * @version UniqueBinarySearchTrees.java, v 0.1 2018/8/16 21:32
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] nums = new int[n + 1];

        nums[0] = 1;
        for(int index = 1; index <= n; index ++){
            if(index == 1){
                nums[index] = 1;
            }

            int countIndex = 0;
            for (int y = 1; y <= index / 2; y++){
                countIndex += nums[y - 1] * nums[index - y];
            }
            countIndex *= 2;
            if(index % 2 == 1){
                countIndex += nums[index / 2] * nums[index / 2];
            }

            nums[index] = countIndex;
        }

        return nums[n];
    }

}
