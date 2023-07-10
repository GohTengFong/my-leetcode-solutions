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
    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        return false;
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        } else if (isLeaf(node)) {
            return 1;
        } else {
            return 1 + countNodes(node.left) + countNodes(node.right);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        int rankOfNode = 1 + countNodes(root.left);

        if (k == rankOfNode) {
            return root.val;
        } else if (k < rankOfNode) {
            return kthSmallest(root.left, k);
        } else if (k > rankOfNode) {
            return kthSmallest(root.right, k - rankOfNode);
        }
    
        return -1;
    }
}