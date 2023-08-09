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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);

        for (ListNode head : lists) {
            if (head != null) minHeap.offer(head);
        }

        ListNode dummyNode = new ListNode(0);
        ListNode temp = dummyNode;

        while (!minHeap.isEmpty()) {
            temp.next = minHeap.poll();
            temp = temp.next;

            if (temp.next != null) minHeap.offer(temp.next);
        }

        return dummyNode.next;
    }
}