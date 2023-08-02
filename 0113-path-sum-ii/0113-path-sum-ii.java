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

    private void dfs(TreeNode node, int target, ArrayList<Integer> currList, ArrayList<List<Integer>> answer) {
        if (isLeaf(node) && target - node.val == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currList);
            temp.add(node.val);
            answer.add(temp);
            return;
        } else if (isLeaf(node)) return;

        currList.add(node.val);

        if (node.left != null) dfs(node.left, target - node.val, currList, answer);
        if (node.right != null) dfs(node.right, target - node.val, currList, answer);

        currList.remove(currList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> currList = new ArrayList<Integer>();

        if (root == null) return answer;

        dfs(root, targetSum, currList, answer);

        return answer;
    }
}