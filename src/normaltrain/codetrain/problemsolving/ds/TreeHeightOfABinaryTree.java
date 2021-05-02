package normaltrain.codetrain.problemsolving.ds;

import java.util.Scanner;

public class TreeHeightOfABinaryTree {

    //firstSolution
    public static int height(Node root) {
        // Write your code here.
        int result = 0;
        if(root.left != null){
            result = result + heightS(root.left);
        }
        if(root.right != null){
            int rightResult = 0;
            rightResult = rightResult + heightS(root.right);
            if(rightResult > result){
                result = rightResult;
            }
        }
        return result;
    }

    public static int heightS(Node node){
        int result = 1;
        int rightResult = 1;
        if(node.left != null){
            result = 1 + heightS(node.left);
        }

        if(node.right != null){
            rightResult = 1 + heightS(node.right);
        }

        return Math.max(result, rightResult);
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
        int height = height(root);
        System.out.println(height);
    }
}
