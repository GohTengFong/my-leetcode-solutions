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
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        list.sort(null);

        ListNode stationary = new ListNode(0);
        ListNode moving = stationary;

        for (int i = 0; i < list.size(); i++) {
            moving.next = new ListNode(list.get(i));
            moving = moving.next;
        }

        return stationary.next;
    }
}