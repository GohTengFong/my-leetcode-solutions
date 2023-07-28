/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>(); // mapping of real : copy nodes

        Node secondPass = head;
        Node stationary = new Node(0);
        Node moving = stationary;

        while (head != null) {
            moving.next = new Node(head.val);
            moving = moving.next;

            map.put(head, moving);

            head = head.next;
        }
        moving.next = null;
        map.put(moving, null);
        moving = stationary;
        
        while (secondPass != null) {
            Node random = secondPass.random;
            Node randomCopied = map.get(random);

            moving.next.random = randomCopied;

            moving = moving.next;
            secondPass = secondPass.next;
        }

        return stationary.next;
    }
}