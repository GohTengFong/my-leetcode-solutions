/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointer1 = headA;
        ListNode pointer2 = headB;
        
        while (pointer1 != pointer2) {
            pointer1 = (pointer1 == null) ? headB : pointer1.next;
            pointer2 = (pointer2 == null) ? headA : pointer2.next;
        }

        return pointer1;
    }
}