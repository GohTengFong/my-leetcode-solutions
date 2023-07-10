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
    public ListNode partition(ListNode head, int x) {
        ListNode moving = head;
        ListNode stationary = head;

        ListNode temp = new ListNode(0);
        ListNode answer = temp;
        
        while (moving != null) {
            if (stationary.val < x && moving.val < x) {
                temp.next = new ListNode(moving.val);

                temp = temp.next;
                moving = moving.next;
                stationary = stationary.next;
            } else if (stationary.val >= x && moving.val >= x) {
                moving = moving.next;
            } else if (stationary.val >= x && moving.val < x) {
                temp.next = new ListNode(moving.val);

                temp = temp.next;
                moving = moving.next;
            }
        }

        while (stationary != null) {
            if (stationary.val >= x) {
                temp.next = new ListNode(stationary.val);

                temp = temp.next;
                stationary = stationary.next;
            } else {
                stationary = stationary.next;
            }
        }

        return answer.next;
    }
}