/**
 *
 Given an unsorted array of integers, find the number of longest increasing subsequence.

 Example 1:
 Input: [1,3,5,4,7]
 Output: 2
 Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 Example 2:
 Input: [2,2,2,2,2]
 Output: 5
 Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 */
package com.peijin.leetcode.algorithm.done;

public class NumberofLongestIncreasingSubsequence {
    // 获取0~index中，最大值小于maxValue的最长路径数量
    public int findNumberOfLIS(){
        return 0;
    }

    public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[][] lengths = new int[2][nums.length];
        lengths[0][0] = 1;
        lengths[1][0] = 1;
        int maxLength = 1;
        int maxLengthCount = 1;
        for(int i = 1; i < nums.length; i++){
            int currentLength = 1;
            int currentLengthCount = 0;
            for(int j = i - 1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    if(lengths[0][j] + 1 == currentLength){
                        currentLengthCount += lengths[1][j];
                    }
                    if(lengths[0][j] + 1 > currentLength){
                        currentLength = lengths[0][j] + 1;
                        currentLengthCount = lengths[1][j];
                    }
                }
            }

            lengths[0][i] = currentLength;
            lengths[1][i] = maxLengthCount;
            if(currentLength > maxLength){
                maxLengthCount = currentLengthCount;
                maxLength = currentLength;
            }else if (currentLength == maxLength){
                maxLengthCount++;
            }
        }

        return maxLengthCount;
    }

    public static void main(String args[]){
        NumberofLongestIncreasingSubsequence test = new NumberofLongestIncreasingSubsequence();
        int[] nums = new int[]{1,2,4,3,5,4,7,2};
        System.out.println(test.findNumberOfLIS(nums));
    }
}
