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
    private int[] sumAndCount(TreeNode node, int[] sumNCount) {
        sumNCount[0] += node.val;
        sumNCount[1] += 1;

        if (node.left != null) sumAndCount(node.left, sumNCount);
        if (node.right != null) sumAndCount(node.right, sumNCount);

        return sumNCount;
    }

    public int averageOfSubtree(TreeNode root) {
        int answer = 0;

        int[] sumNCount = new int[2];
        sumNCount = sumAndCount(root, sumNCount);

        int average = sumNCount[0] / sumNCount[1];
        if (root.val == average) answer++;

        if (root.left != null) answer += averageOfSubtree(root.left);
        if (root.right != null) answer += averageOfSubtree(root.right);

        return answer;
    }
}