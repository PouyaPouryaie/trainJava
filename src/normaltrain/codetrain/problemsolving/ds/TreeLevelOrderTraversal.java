package normaltrain.codetrain.problemsolving.ds;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TreeLevelOrderTraversal {

    public static void levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        if(root.left !=null){
            queue.add(root.left);
        }
        if(root.right != null){
            queue.add(root.right);
        }
        System.out.print(root.data + " ");
        while (!queue.isEmpty()){
            Node node = queue.pop();
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
            System.out.print(node.data + " ");
        }
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
        levelOrder(root);
    }
}
