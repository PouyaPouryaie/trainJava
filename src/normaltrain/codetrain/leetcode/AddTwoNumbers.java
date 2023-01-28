package normaltrain.codetrain.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored
 * in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4, listNode3);
//        ListNode listNode2 = new ListNode(2, listNode4);
//
//        ListNode listNode24 = new ListNode(4);
//        ListNode listNode26 = new ListNode(6, listNode24);
//        ListNode listNode25 = new ListNode(5, listNode26);

        ListNode listNode2 = new ListNode(0);

        ListNode listNode25 = new ListNode(0);

        ListNode sample = listNode2;
        StringBuilder first = new StringBuilder("");
        while (Objects.nonNull(sample)){
            first.append(sample.val);
            sample = sample.next;
        }
        sample = listNode25;
        StringBuilder second = new StringBuilder("");
        while (Objects.nonNull(sample)){
            second.append(sample.val);
            sample = sample.next;
        }
        String firstArr = reverseData(first.toString().split(""));
        String secondArr = reverseData(second.toString().split(""));

        int sum = Integer.parseInt(firstArr) + Integer.parseInt(secondArr);
        String[] result = String.valueOf(sum).split("");
        ListNode nodeBefore = new ListNode();
        for(int i = 0 ; i < result.length-1; i = i+2){
            ListNode newData = new ListNode(Integer.parseInt(result[i]));
            ListNode newData2 = new ListNode(Integer.parseInt(result[i+1]), newData);
            nodeBefore = newData2;
            if(i == result.length - 1){
                break;
            }
        }
        ListNode endNode = new ListNode(Integer.parseInt(result[result.length-1]), nodeBefore);

        sample = endNode;
        StringBuilder resultCheck = new StringBuilder("");
        while (Objects.nonNull(sample)){
            resultCheck.append(sample.val);
            sample = sample.next;
        }
        System.out.println(resultCheck);
    }

    public static String reverseData(String[] data){
        StringBuilder newData = new StringBuilder();
        for (int i = data.length-1;i>=0; i--){
            newData.append(data[i]);
        }
        return newData.toString();
    }
}

class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}