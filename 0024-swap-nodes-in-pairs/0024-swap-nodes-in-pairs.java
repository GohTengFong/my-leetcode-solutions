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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            head.next.next = head;
            head = head.next;
            head.next.next = null;
            return head;
        }

        ListNode wish = swapPairs(head.next.next);

        head.next.next = head;
        head = head.next;
        head.next.next = wish;

        return head;
    }
}