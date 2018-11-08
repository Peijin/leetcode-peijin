/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:
    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*/
package com.peijin.leetcode.algorithm.done;
import java.util.HashMap;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> differenceMap = new HashMap<Integer,Integer>();

        for(int index = 0; index < numbers.length; index++){
            differenceMap.put(target - numbers[index], index);
        }

        for(int index = 0; index < numbers.length; index++){
            Integer difference = differenceMap.get(numbers[index]);
            if(difference != null && difference != index){
                return new int[]{index + 1, difference + 1};
            }
        }

        throw new RuntimeException();
    }
}
