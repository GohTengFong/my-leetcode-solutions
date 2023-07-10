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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (length == n) {
            return head.next;
        }

        ListNode temp2 = head;
        while (length - n != 1) {
            temp2 = temp2.next;
            length--;
        }

        temp2.next = temp2.next.next;

        return head;
    }
}