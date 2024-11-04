package basictrain.codetrain.leetcode.algorithm1;

/**
 * DFS / BFS
 * 617. Merge Two Binary Trees
 * You are given two binary trees root1 and root2.
 *
 * Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
 * Return the merged tree.
 * Note: The merging process must start from the root nodes of both trees.
 *
 * Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * Output: [3,4,5,5,4,null,7]
 */
public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

    }

    public TreeNode secondSolution(TreeNode root1, TreeNode root2){
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode root3 = new TreeNode(root1.val + root2.val);
        root3.left = secondSolution(root1.left, root2.left);
        root3.right = secondSolution(root1.right, root2.right);

        return root3;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        int leftVal = 0;
        int rightVal = 0;
        if(root1 == null && root2 == null){
            return null;
        }
        if(root1 == null && root2 != null){
            rightVal = root2.val;
            TreeNode left = mergeTrees(null, root2.left);
            TreeNode right = mergeTrees(null, root2.right);
            return new TreeNode(rightVal, left, right);
        }
        else if(root2 == null && root1 != null){
            leftVal = root1.val;
            TreeNode left = mergeTrees(root1.left, null);
            TreeNode right = mergeTrees(root1.right, null);
            return new TreeNode(leftVal, left, right);
        }else{
            leftVal = root1.val;
            rightVal = root2.val;
            TreeNode mergeNode = new TreeNode(leftVal + rightVal);
            TreeNode left = mergeTrees(root1.left, root2.left);
            TreeNode right = mergeTrees(root1.right, root2.right);
            mergeNode.left = left;
            mergeNode.right = right;
            return mergeNode;
        }
    }

    public class TreeNode {
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
}
