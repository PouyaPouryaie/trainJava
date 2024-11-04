package basictrain.codetrain.leetcode.algorithm1;

/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
//        ListNode listNode6 = new ListNode(6);
//        ListNode listNode5 = new ListNode(5, listNode6);
//        ListNode listNode4 = new ListNode(4, listNode5);
//        ListNode listNode3 = new ListNode(3, listNode4);
//        ListNode listNode2 = new ListNode(2,listNode3);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode = secondSolution(listNode1, 1);
        for (ListNode list = listNode; list != null; list = list.next) {
            System.out.println(list.val);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode listNode = head;
        int i = 0;
        while (listNode.next != null) {
            listNode = listNode.next;
            i++;
        }
        if (i == 0) {
            return null;
        } else if(i == n-1){
            first = first.next;
        } else {
            i = i - n;
            listNode = head;
            while (i != 0) {
                listNode = listNode.next;
                i--;
            }
            listNode.next = listNode.next.next;
        }
        return first;
    }

    public static ListNode secondSolution(ListNode head, int n) {
        ListNode current = new ListNode(0);
        current.next = head;
        ListNode start = current;
        ListNode end = current;

        for(int i=1;i<=n+1;i++){
            end=end.next;
        }

        while (end != null){
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return current.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
