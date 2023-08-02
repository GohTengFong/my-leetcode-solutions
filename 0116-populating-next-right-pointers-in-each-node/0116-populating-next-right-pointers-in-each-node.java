/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;

        LinkedList<Node> frontier1 = new LinkedList<Node>();
        frontier1.offer(root);

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            LinkedList<Node> frontier2 = new LinkedList<Node>();

            if (size == 1) {
                Node rootNode = frontier1.poll();
                rootNode.next = null;
                frontier2.add(rootNode.left);
                frontier2.add(rootNode.right);
            }

            Node prev = frontier1.poll();

            while (prev != null) {
                prev.next = frontier1.poll();

                if (prev.left != null) frontier2.offer(prev.left);
                if (prev.right != null) frontier2.offer(prev.right);

                prev = prev.next;
            }            

            frontier1 = frontier2;
        }

        return root;
    }
}