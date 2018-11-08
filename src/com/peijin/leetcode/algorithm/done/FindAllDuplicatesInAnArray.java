/**
 * Given an array of integers, 1 °‹ a[i] °‹ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
package com.peijin.leetcode.algorithm.done;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO ¿‡√Ë ˆ
 *
 * @author peijin.zhangpj
 * @version FindAllDuplicatesInAnArray.java, v 0.1 2018/8/15 11:13
 */
public class FindAllDuplicatesInAnArray {

    public static void main(String args[]){
        int[] nums = new int[]{1,4,3,2,8,2,3,1};
        FindAllDuplicatesInAnArray test = new FindAllDuplicatesInAnArray();
        System.out.println(test.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int index = 0; index < nums.length; index ++){
            do{
                if(nums[index] == 0 || nums[index] - 1 == index) break;
                if(nums[nums[index] - 1] == nums[index]){
                    result.add(nums[index]);
                    nums[index] = 0;
                    break;
                }

                int nextNum = nums[nums[index] - 1];
                nums[nums[index] - 1] = nums[index];
                nums[index] = nextNum;
            }while (true);
        }

        return result;
    }
}
