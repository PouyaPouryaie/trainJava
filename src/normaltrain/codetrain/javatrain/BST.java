package normaltrain.codetrain.javatrain;

import java.util.Scanner;

public class BST {

    public static int getHeight(NodeBST root){
        //Write your code here
        if(root == null){
            return -1;
        }
        else{
            return 1 + (Math.max(getHeight(root.left), getHeight(root.right)));
        }
    }

    public static NodeBST insert(NodeBST root,int data){
        if(root==null){
            return new NodeBST(data);
        }
        else{
            NodeBST cur;
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
        NodeBST root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}

class NodeBST {
    public NodeBST left,right;
    int data;

    public NodeBST(int data) {
        this.data = data;
        right=left=null;
    }
}


