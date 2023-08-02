/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode first = null; 
    private TreeNode second = null;
    private TreeNode prev = null;

    private void swap(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        inOrderTraversal(node.left);

        if (prev != null) {
            if (first == null && prev.val >= node.val) first = prev;
        }

        if (first != null && prev.val >= node.val) second = node;
        
        prev = node;

        inOrderTraversal(node.right);
    }

    public void recoverTree(TreeNode root) {
        inOrderTraversal(root);
        swap(first, second);
    }
}