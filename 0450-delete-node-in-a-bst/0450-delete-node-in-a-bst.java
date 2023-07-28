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
    private TreeNode searchMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // returns the subtree with the node deleted
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) { // recursively looking for the node to delete
            root.left = deleteNode(root.left, key); // assigning the returned node to node.left
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else { // found the node to delete
            if (root.left == null) return root.right; // node has right child only
            if (root.right == null) return root.left; // node has left child only

            // node has 2 children
            TreeNode rightSmallest = searchMin(root.right); // look for successor
            rightSmallest.left = root.left; // left child of node to delete is assigned to successor (we know successor has no left child due to searchMin())
            return root.right; // deleted node's right child to take over it's place
        }

        return root;
    }
}