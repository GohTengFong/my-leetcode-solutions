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

    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        LinkedList<Integer> monoDecreasing = new LinkedList<Integer>();

        ListNode reversed = reverse(head);

        while (reversed != null) {
            while (!monoDecreasing.isEmpty() && reversed.val >= monoDecreasing.peek()) {
                monoDecreasing.pop();
            }

            if (monoDecreasing.isEmpty()) {
                monoDecreasing.push(reversed.val);
                temp.add(0);
            } else if (reversed.val < monoDecreasing.peek()) {
                temp.add(monoDecreasing.peek());
                monoDecreasing.push(reversed.val);
            }

            reversed = reversed.next;
        }

        Collections.reverse(temp);
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}