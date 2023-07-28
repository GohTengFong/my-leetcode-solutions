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

    private void dfs(TreeNode node, ArrayList<Integer> leafSeq) {
        if (node == null) return;
        
        dfs(node.left, leafSeq);
        if (isLeaf(node)) leafSeq.add(node.val);
        dfs(node.right, leafSeq);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (isLeaf(root1) && isLeaf(root2)) return (root1.val == root2.val);

        ArrayList<Integer> leafSeq1 = new ArrayList<Integer>();
        ArrayList<Integer> leafSeq2 = new ArrayList<Integer>();
        dfs(root1, leafSeq1);
        dfs(root2, leafSeq2);

        return leafSeq1.equals(leafSeq2);
    }
}