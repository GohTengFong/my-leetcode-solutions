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
    private int findLength(ListNode node, int length) {
        if (node == null) {
            return length;
        } else {
            return findLength(node.next, length + 1);
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        } else if (head.next.next == null) {
            return head.next;
        }

        int length = findLength(head, 0);
        double mid = Math.floor(length / 2 + 1);

        ListNode answer = head;

        while (mid != 1) {
            answer = answer.next;
            mid -= 1;
        }

        return answer;
    }
}