package basictrain.codetrain.javatrain;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BSTLevelOrderTraversal {

    static void levelOrder(NodeLevelOrder root){
        //Write your code here
        Queue<NodeLevelOrder> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);

            while (!queue.isEmpty()){
                NodeLevelOrder n = queue.remove();
                System.out.print(n.data + " ");
                if(n.left != null){
                    queue.add(n.left);
                }
                if(n.right != null){
                    queue.add(n.right);
                }
            }
        }
    }

    public static NodeLevelOrder insert(NodeLevelOrder root,int data){
        if(root==null){
            return new NodeLevelOrder(data);
        }
        else{
            NodeLevelOrder cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        NodeLevelOrder root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}

class NodeLevelOrder{
    NodeLevelOrder left,right;
    int data;
    NodeLevelOrder(int data){
        this.data=data;
        left=right=null;
    }
}
