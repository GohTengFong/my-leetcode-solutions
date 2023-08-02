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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();

        if (root == null) return answer;

        LinkedList<TreeNode> frontier1 = new LinkedList<TreeNode>();
        frontier1.offer(root);

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            ArrayList<Integer> level = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = frontier1.poll();

                if (currNode.left != null) frontier1.offer(currNode.left);
                if (currNode.right != null) frontier1.offer(currNode.right);

                level.add(currNode.val);
            }

            answer.add(level);
        }

        Collections.reverse(answer);
        
        return answer;
    }
}