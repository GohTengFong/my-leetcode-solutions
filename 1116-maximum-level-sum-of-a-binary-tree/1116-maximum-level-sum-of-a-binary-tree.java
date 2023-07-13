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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> frontier1 = new LinkedList<TreeNode>();
        frontier1.add(root);
        int currMax = Integer.MIN_VALUE;
        int answer = 0;
        int currLevel = 1;

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            Queue<TreeNode> frontier2 = new LinkedList<TreeNode>();
            int currCount = Integer.MIN_VALUE;
            
            for (int i = 0; i < size; i++) {
                TreeNode currNode = frontier1.poll();

                if (currNode != null) {
                    if (currCount == Integer.MIN_VALUE) {
                        currCount = 0;
                        currCount += currNode.val;
                    } else {
                        currCount += currNode.val;
                    }

                    frontier2.add(currNode.left);
                    frontier2.add(currNode.right);
                }
            }

            if (currCount > currMax) {
                currMax = currCount;
                answer = currLevel;
            }

            currLevel++;
            frontier1 = frontier2;
        }
        
        return answer;
    }
}