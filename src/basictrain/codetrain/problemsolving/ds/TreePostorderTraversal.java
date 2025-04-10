package basictrain.codetrain.problemsolving.ds;

import java.util.Scanner;

public class TreePostorderTraversal {

    public static void postOrder(Node root) {
        if(root.left != null) {
            postOrder(root.left);
        }
        if(root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
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
        postOrder(root);
    }
}
