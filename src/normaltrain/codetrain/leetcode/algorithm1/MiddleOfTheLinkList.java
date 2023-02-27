package normaltrain.codetrain.leetcode.algorithm1;

/**
 * 876. Middle of the Linked List
 * <p>
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * ex:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 */
public class MiddleOfTheLinkList {
    public static void main(String[] args) {
        ListNode listNode6 = new ListNode(6);
        ListNode listNode5 = new ListNode(5, listNode6);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        ListNode listNode = middleNode(listNode1);
        System.out.println(listNode.val);
    }

    public static ListNode middleNode(ListNode head) {
        int i = 0;
        ListNode listNode = head;
        ListNode listNodeNew = new ListNode(head.val);
        while (listNode.next != null){
            i++;
            listNode = listNode.next;
        }
        i++;
        if(i % 2 == 0){
            i = (i / 2) + 1;
        }else{
            i = (i / 2) + 1;
        }
        ListNode listNodeIndex = head;
        int j = 1;
        while (j != i){
            listNodeIndex = listNodeIndex.next;
            j++;
        }
        return listNodeIndex;
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
