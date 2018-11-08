/**
 *
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
package com.peijin.leetcode.algorithm.done;

public class HouseRobber {
    // 思路1：在第i间房子上，只有两个选择，要么偷，要么不偷。如果偷，则取i加上i+2后的最大值；不偷，则是i+1之后的最大值
    // 思路2：从前往后数，记当前最大及前一个位置最大值。
    // 2优于1
    public int rob(int[] nums) {
        // 思路1注释掉了
        //(nums.length == 0) return 0;
        //return rob(nums, 0);

        //思路2直接解：a代表当前最大值，b代表前一个位置的最大值
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i ++){
            int temp = b;
            b = a;
            a = Math.max(a, temp + nums[i]);
        }
        return Math.max(a, b);

        //增强版的答案
        //return Math.max(rob2(nums, 1, nums.length - 1), nums[0] + rob2(nums,2, nums.length - 2));
    }

    // 思路1的方法
    public int rob(int[] nums, int index){
        if(index >= nums.length) return 0;
        if(index == nums.length - 1) return nums[nums.length - 1];

        return Math.max(nums[index] + rob(nums, index + 2),rob(nums, index + 1));
    }

    // 增强版，数组是个圆
    public int rob2(int[] nums, int start, int end) {
        if(start > end) return 0;
        if(start == end) return nums[start];
        int a = 0, b = 0;
        for(int i = start; i <= end; i ++){
            int temp = b;
            b = a;
            a = Math.max(a, temp + nums[i]);
        }

        return Math.max(a, b);
    }
}
