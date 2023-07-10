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
        ListNode stationary = head;
        ListNode moving = head;

        while (moving != null) {
            if (moving.next == null && stationary.val == moving.val) {
                stationary.next = null;
            }

            if (stationary.val == moving.val) {
                moving = moving.next;
            } else {
                stationary.next = moving;
                stationary = moving;
            }
        }

        return head;
    }
}