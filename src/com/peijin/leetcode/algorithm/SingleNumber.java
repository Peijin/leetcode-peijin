/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 */
package com.peijin.leetcode.algorithm;

public class SingleNumber {
    // 遍历一遍，用map存储出现的次数❌
    // 排序再左右对比❌
    // without using extra memory，也就是说只能找一个算法，当一次数出现两次时，当它没出现过，理所当然想到异或运算
    public int singleNumber(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

    // TODO 增强版，如果其他数都出现3次，只有一个数出现1次，找出来。
}
