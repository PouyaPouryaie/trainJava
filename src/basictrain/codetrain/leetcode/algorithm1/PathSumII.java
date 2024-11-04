package basictrain.codetrain.leetcode.algorithm1;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode eleven = new TreeNode(11, seven, two);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode fourTwo = new TreeNode(4, five, one);
        TreeNode thirteen = new TreeNode(13);
        TreeNode eight = new TreeNode(8, thirteen, fourTwo);
        TreeNode four = new TreeNode(4, eleven, null);
        TreeNode root = new TreeNode(5, four, eight);
        List<List<Integer>> lists = pathSum(root, 22);
        System.out.println(lists);
    }



    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        DFS(root, 0, targetSum, result, new ArrayList<>());
        return result;
    }

    public static void DFS(TreeNode node, int candidateSum, int targetSum, List<List<Integer>> result, List<Integer> path) {
        if(node == null) return;
        candidateSum += node.val;

        if(candidateSum <= targetSum) {
            path.add(node.val);
            if(node.left == null && node.right == null) {
                if(candidateSum == targetSum) {
                    result.add(new ArrayList<>(path));
                    path.remove(path.size() - 1);
                }
            }
            else {
                DFS(node.left, candidateSum, targetSum, result, path);
                DFS(node.right, candidateSum, targetSum, result, path);
                path.remove(path.size() - 1);
            }
        }else {
            candidateSum -= node.val;
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