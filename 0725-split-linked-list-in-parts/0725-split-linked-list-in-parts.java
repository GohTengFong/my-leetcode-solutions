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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        if (length == 0) return new ListNode[k];
        
        int extra = 0;
        if (length % k != 0) extra = length % k;

        ListNode[] answer = new ListNode[k];

        ListNode front = head;
        ListNode moving = head;
        ListNode prevMoving = null;
        for (int i = 0; i < k; i++) {
            int normalSegmentSize = length / k;

            if (extra != 0) {
                normalSegmentSize++;
                extra--;
            }

            while (normalSegmentSize != 1) {
                moving = moving.next;
                normalSegmentSize--;
            }

            if (moving.next == null) {
                answer[i] = front;
                break;
            }

            prevMoving = moving;
            moving = moving.next;

            prevMoving.next = null;

            answer[i] = front;

            front = moving;
        }

        return answer;
    }
}