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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> frontier1 = new LinkedList<TreeNode>();
        int iteration = 0; // if even -> add right to left, if odd -> add left to right

        if (root == null) return answer;

        frontier1.offer(root);

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            LinkedList<TreeNode> frontier2 = new LinkedList<TreeNode>();
            ArrayList<Integer> level = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = frontier1.poll();

                level.add(currNode.val);

                if (currNode.left != null) frontier2.offer(currNode.left);
                if (currNode.right != null) frontier2.offer(currNode.right);
            }

            if (iteration % 2 == 1) Collections.reverse(level);

            answer.add(level);
            iteration++;
            frontier1 = frontier2;
        }

        return answer;
    }
}