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
        if (node.left == null && node.right == null) return true;

        return false;
    }

    private void preOrderTraversal(TreeNode root, ArrayList<TreeNode> preOrder) {
        if (root == null) return;
        
        preOrder.add(root);
        preOrderTraversal(root.left, preOrder);
        root.left = null;
        preOrderTraversal(root.right, preOrder);
        root.right = null;
    }

    public void flatten(TreeNode root) {
        if (root == null || isLeaf(root)) return;

        ArrayList<TreeNode> preOrder = new ArrayList<TreeNode>();
        preOrderTraversal(root, preOrder);

        for (int i = 1; i < preOrder.size(); i++) {
            root.right = preOrder.get(i);
            root = root.right;
        }
    }
}