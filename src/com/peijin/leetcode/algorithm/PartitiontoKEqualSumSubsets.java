/**
 *
 Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.

 Example 1:
 Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 Output: True
 Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 Note:

 1 <= k <= len(nums) <= 16.
 0 < nums[i] < 10000.
 */
package com.peijin.leetcode.algorithm;

import java.util.Arrays;

public class PartitiontoKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % k != 0) return false;
        int equalSum = sum / k;

        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 0) continue;
            if(!requiredValue(nums, i, equalSum)) return false;
        }

        return true;
    }

    public boolean requiredValue(int[] nums, int index, int sum){
        if(nums[index] == sum){
            nums[index] = 0;
            return true;
        }

        if(index == 0){
            return false;
        }

        for(int i = index - 1; i >= 0; i--){
            if(requiredValue(nums, i, sum - nums[index])){
                nums[index] = 0;
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        int[] test = new int[]{2,2,10,5,2,7,2,2,13};
        PartitiontoKEqualSumSubsets s = new PartitiontoKEqualSumSubsets();
        System.out.println(s.canPartitionKSubsets(test, 3));
    }
}
