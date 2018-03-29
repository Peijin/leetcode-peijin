/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
package com.peijin.leetcode.algorithm;

public class MaximumSubarray {
    /**
     * 思路：记leftMax为以i结尾的最大的值，那么只需遍历一遍，每个i的时候，看i-1的最大值是否为正，是则加上i的值，否则只要i本身的值
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int leftMax = nums[0];

        for(int i = 1; i < nums.length; i ++){
            leftMax = nums[i] + (leftMax > 0 ? leftMax : 0);
            max = Math.max(max, leftMax);
        }

        return max;
    }

}
