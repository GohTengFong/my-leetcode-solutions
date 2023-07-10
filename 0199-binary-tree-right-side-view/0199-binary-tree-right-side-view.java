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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if (root == null) {
            return list;
        }

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();

        q1.add(root);

        while (!q1.isEmpty()) {
            int size = q1.size();
            Queue<TreeNode> q2 = new LinkedList<TreeNode>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = q1.poll();

                if (q1.isEmpty()) {
                    list.add(currNode.val);
                }

                if (currNode.left != null) {
                    q2.add(currNode.left);
                }

                if (currNode.right != null) {
                    q2.add(currNode.right);
                }
            }

            q1 = q2;
        }
        
        return list;
    }
}