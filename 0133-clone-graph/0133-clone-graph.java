/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> visited = new HashMap<Node, Node>(); // key = old Node, value = new Node

        Queue<Node> frontier1 = new LinkedList<Node>();
        frontier1.offer(node);

        while (!frontier1.isEmpty()) {
            int size = frontier1.size();
            Queue<Node> frontier2 = new LinkedList<Node>();

            for (int i = 0; i < size; i++) {
                Node currNode = frontier1.poll();
                List<Node> currNeighbours = currNode.neighbors;

                // create old Node, new Node pair if it does not exist
                if (!visited.containsKey(currNode)) {
                    visited.put(currNode, new Node(currNode.val, new ArrayList<Node>()));
                }

                List<Node> newNeighbours = visited.get(currNode).neighbors;
                for (Node currNeighbour : currNeighbours) {
                    if (!visited.containsKey(currNeighbour)) {
                        visited.put(currNeighbour, new Node(currNeighbour.val));
                        frontier2.offer(currNeighbour);
                    }

                    newNeighbours.add(visited.get(currNeighbour));
                }
            }

            frontier1 = frontier2;
        }

        Node newNode = visited.get(node);
        return newNode;
    }
}