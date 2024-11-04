package basictrain.codetrain.javatrain;

import java.util.Scanner;

class Node{
    int data;
    NodeLinkList next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedListTrain {

    public static NodeLinkList insert(NodeLinkList head, int data) {
        //Complete this method
        NodeLinkList index = head;
        if(index == null){
            head = new NodeLinkList(data);
        }
        else{
            while (index.next != null){
                index = index.next;
            }
            NodeLinkList last = new NodeLinkList(data);
            index.next = last;
        }
        return head;
    }

    public static void display(NodeLinkList head) {
        NodeLinkList start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        NodeLinkList head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
