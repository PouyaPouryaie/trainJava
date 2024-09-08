package normaltrain.codetrain.leetcode.algorithm1.interview;

/*
 >>> Fast & Slow Pointers pattern
    The Fast & Slow Pointers (Tortoise and Hare) pattern is used to detect cycles in linked lists and other similar structures.
    Initialize two pointers, one moving one step at a time (slow) and the other moving two steps at a time (fast).
        If there is a cycle, the fast pointer will eventually meet the slow pointer.
        If the fast pointer reaches the end of the list, there is no cycle.

Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following
 the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example:
Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }

        }
        return false;
    }


    // my solution
    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast;
        boolean trip = true;

        if(slow.next == null) {
            return false;
        }

        else {
            fast = slow.next;

            if(fast.next != null) {
                if(fast.next.val == slow.val) {
                    return true;
                }
            }

            fast = fast.next;
        }

        while(trip) {
            slow = slow.next;
            fast = fast.next;

            if(fast == null) {
                return false;
            } else {
                if(fast.next != null) {
                    fast = fast.next;
                    if(fast.val == slow.val) {
                        return true;
                    }
                }
                else {
                    return false;
                }
            }
        }

        return false;
    }


    public static void main(String args[]) {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode NegativeFour = new ListNode(-4);
        three.next = two;
        two.next = zero;
        zero.next = NegativeFour;
        NegativeFour.next = two;
        LinkedListCycle obj = new LinkedListCycle();
        boolean result = obj.hasCycle(three);
        System.out.printf("Result is: %s", result);
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}