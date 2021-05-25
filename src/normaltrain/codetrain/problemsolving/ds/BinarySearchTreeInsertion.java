package normaltrain.codetrain.problemsolving.ds;

import java.util.Scanner;

public class BinarySearchTreeInsertion {

    public static void preOrder( Node root ) {

        if( root == null)
            return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static Node insert(Node root,int data) {
        if(root == null){
            return new Node(data);
        }
        else{
            Node cur;
            if(root.data < data){
                cur = insert(root.right, data);
                root.right = cur;
            }
            else{
                cur = insert(root.left, data);
                root.left = cur;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        preOrder(root);
    }
}
