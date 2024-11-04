package basictrain.codetrain.leetcode.algorithm1.interview;

/* Binary Tree Traversal - DFS
Binary Tree Traversal involves visiting all the nodes in a binary tree in a specific order.

PreOrder: root -> left -> right
InOrder: left -> root -> right
PostOrder: left -> right -> root

Explanation
1.Inorder traversal visits nodes in the order: left, root, right.
2.Use recursion or a stack to traverse the tree in this order.

example:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Resource
https://leetcode.com/problems/binary-tree-paths/solutions/4091706/brute-force-to-efficient-method-java-c-python-javascript-c/
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {

    public static void main(String[] args) {
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, null, five);
        TreeNode tree = new TreeNode(3);
        TreeNode root = new TreeNode(1, two, tree);
        List<String> strings = binaryTreePaths(root);
        System.out.println("travers is: " + strings);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);

        System.out.println(a);
    }

    static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        DFS(root, "", res);
        return res;
    }

    static void DFS(TreeNode node, String path, List<String> res) {
        if(node == null) return;
        path += node.val;
        if(node.left == null && node.right == null) {
            res.add(path);
        }else {
            path += "->";
            DFS(node.left, path, res);
            DFS(node.right, path, res);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}