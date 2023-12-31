/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
			return null;
		} else if (head.next == null) {
			return new TreeNode(head.val);
		}

    ListNode mid = head;
		ListNode fastPt = head;
		ListNode prevMid = null;

    while (fastPt != null && fastPt.next != null) {
      prevMid = mid;
      mid = mid.next;
      fastPt = fastPt.next.next;
    }

    if (prevMid != null) {
			prevMid.next = null;
		}

    TreeNode node = new TreeNode(mid.val);
    node.left = sortedListToBST(head);
    node.right = sortedListToBST(mid.next);

    return node;
  }
}