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
    public ListNode findMiddleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode current = head;

        ListNode middle = findMiddleNode(head);
        ListNode reversedMiddle = reverseLinkedList(middle);

        while (reversedMiddle.next != null) {
            ListNode tempCurrentNode = current.next;
            current.next = reversedMiddle;
            current = tempCurrentNode;

            ListNode tempRevNode = reversedMiddle.next;
            reversedMiddle.next = current;
            reversedMiddle = tempRevNode;
        }
    }
}