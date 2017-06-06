/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
*/

package com.peijin.leetcode.algorithm;

/**
 * Created by peijin.zhangpj on 2017/6/1.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2 == null ? null : l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode resultHead = null;
        ListNode formerNode = null;

        ListNode currentL1 = l1;
        ListNode currentL2 = l2;

        int carry = 0;
        do{
            int valueL1;
            int valueL2;
            if(currentL1 == null){
                valueL1 = 0;
            }else{
                valueL1 = currentL1.val;
                currentL1 = currentL1.next;
            }
            if(currentL2 == null){
                valueL2 = 0;
            }else{
                valueL2 = currentL2.val;
                currentL2 = currentL2.next;
            }
            ListNode currentNode = new ListNode((valueL1 + valueL2 + carry) % 10);
            carry = (valueL1 + valueL2 + carry) / 10;

            if(resultHead == null){
                resultHead = currentNode;
                formerNode = resultHead;
            }else{
                formerNode.next = currentNode;
                formerNode = currentNode;
            }

        }while(currentL1 != null || currentL2 !=null);
        if(carry == 1){
            formerNode.next = new ListNode(1);
        }
        return resultHead;

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
