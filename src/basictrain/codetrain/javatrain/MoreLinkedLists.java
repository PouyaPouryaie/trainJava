package basictrain.codetrain.javatrain;

import java.util.Scanner;

public class MoreLinkedLists {

    public static NodeLinkList removeDuplicates(NodeLinkList head) {
        //Write your code here
        int indexData = 0;
        if(head != null){
            NodeLinkList index = head;
            while (index.next != null){
                indexData = index.data;
                if(indexData == index.next.data){
                    index.next = index.next.next;
                }
                else {
                    index = index.next;
                }
            }
        }

        return head;
    }

    public static NodeLinkList insert(NodeLinkList head, int data)
    {
        NodeLinkList p=new NodeLinkList(data);
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else
        {
            NodeLinkList start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }
    public static void display(NodeLinkList head)
    {
        NodeLinkList start=head;
        while(start!=null)
        {
            System.out.print(start.data+" ");
            start=start.next;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        NodeLinkList head=null;
        int T=sc.nextInt();
        while(T-->0){
            int ele=sc.nextInt();
            head=insert(head,ele);
        }
        head=removeDuplicates(head);
        display(head);

    }
}


class NodeLinkList {
    int data;
    NodeLinkList next;
    NodeLinkList(int d){
        data=d;
        next=null;
    }

}