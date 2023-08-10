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
    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;

        ListNode wish = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return wish;
    }

    private int length(ListNode node) {
        int length = 0;

        while (node != null) {
            length++;
            node = node.next;
        }

        return length;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (length(head) < k) return head;
        else if (length(head) == k) return reverse(head);

        ListNode temp = head; // pointer at the start of wish
        ListNode prevTemp = head; // pointer at the kth node
        int steps = k;
        while (steps != 0) {
            steps--;
            prevTemp = temp;
            temp = temp.next;
        }
        prevTemp.next = null; // breaking up the first k ListNodes and wish

        ListNode wish = reverseKGroup(temp, k);
        ListNode reversedFirstK = reverse(head);
        
        head.next = wish;

        return reversedFirstK;
    }
}