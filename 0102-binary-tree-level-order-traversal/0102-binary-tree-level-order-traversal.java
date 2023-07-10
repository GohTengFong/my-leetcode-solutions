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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return answer;
        }

        Queue<TreeNode> frontier1 = new LinkedList<TreeNode>();
        frontier1.add(root);

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            Queue<TreeNode> frontier2 = new LinkedList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = frontier1.poll();

                if (currNode.left != null) {
                    frontier2.add(currNode.left);
                }

                if (currNode.right != null) {
                    frontier2.add(currNode.right);
                }

                list.add(currNode.val);
            }

            answer.add(list);
            frontier1 = frontier2;
        }

        return answer;
    }
}