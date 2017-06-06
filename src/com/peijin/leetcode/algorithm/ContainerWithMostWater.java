/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
Find two lines, which together with x-axis forms a container,
such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.
*/

package com.peijin.leetcode.algorithm;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0,
            right = height.length - 1;

        int mostWater = 0;
        while(left < right){
            int bucket = height[left];
            if(bucket > height[right])
                bucket = height[right];

            mostWater = Math.max(mostWater, bucket * (right - left));

            while(left < right && height[left] <= bucket) left ++;
            while(left < right && height[right] <= bucket) right --;

        }

        return mostWater;
    }


    public static void main(String args[]){
        ContainerWithMostWater cwmw = new ContainerWithMostWater();
        cwmw.maxArea(new int[]{1,2,4,3});
    }
}
