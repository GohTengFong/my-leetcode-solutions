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
    private TreeNode construct(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }
        
        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = construct(start, mid - 1, nums);
        root.right = construct(mid + 1, end, nums);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid = start + (end - start) / 2; 
        
        return construct(start, end, nums);
    }
}