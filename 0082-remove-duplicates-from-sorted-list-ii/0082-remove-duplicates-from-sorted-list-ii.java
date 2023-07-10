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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode stationary = new ListNode(0);
        ListNode moving = stationary;
        int prev = Integer.MIN_VALUE;

        while (head != null) {
            if (head.next == null) {
                if (head.val == prev) {
                    head = head.next;
                } else {
                    moving.next = new ListNode(head.val);
                    head = head.next;
                }

            } else if (head.val == head.next.val) {
                head = head.next;
                prev = head.val;
            } else {
                if (head.val == prev) {
                    head = head.next;
                } else {
                    moving.next = new ListNode(head.val);
                    moving = moving.next;
                    head = head.next;
                    prev = Integer.MIN_VALUE;
                }
            }
        }

        return stationary.next;
    }
}