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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode stationary = head;
        ListNode moving = head;

        while (moving.next != null) {
            if (stationary.next.val != val && moving.next.val != val) {
                stationary = stationary.next;
                moving = moving.next;
            } else if (stationary.next.val == val && moving.next.val != val) {
                moving = moving.next;
                stationary.next = moving;
                stationary = moving;
            } else if (stationary.next.val == val) {
                moving = moving.next;
            }
        }

        if (moving.val == val) {
            stationary.next = null;
        }

        return (head.val == val) ? head.next : head;
    }
}