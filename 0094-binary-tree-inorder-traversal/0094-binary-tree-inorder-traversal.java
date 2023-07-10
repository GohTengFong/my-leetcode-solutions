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
    private void recurse(List list, TreeNode node) {
        if (node == null) {
            return;
        } else {
            recurse(list, node.left);
            list.add(node.val);
            recurse(list, node.right);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        recurse(list, root.left);
        list.add(root.val);
        recurse(list, root.right);

        return list;
    }
}