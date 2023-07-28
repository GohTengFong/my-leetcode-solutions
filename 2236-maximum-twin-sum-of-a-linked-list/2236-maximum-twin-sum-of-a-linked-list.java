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
class Solution {
    private ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode wish = reverseList(node.next);

        node.next.next = node;
        node.next = null;

        return wish;
    }

    public int pairSum(ListNode head) {
        if (head.next.next == null) return head.val + head.next.val;

        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        prevSlow.next = null;

        ListNode reversedFirstHalf = reverseList(head);

        int maxCount = Integer.MIN_VALUE;

        while (reversedFirstHalf != null && slow != null) {
            if (reversedFirstHalf.val + slow.val > maxCount) maxCount = reversedFirstHalf.val + slow.val;

            reversedFirstHalf = reversedFirstHalf.next;
            slow = slow.next; 
        }

        return maxCount;
    }
}