/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }

        return false;
    }

    private void buildGraph(TreeNode node, TreeNode parentNode, HashMap graph) {
        List<TreeNode> adjacentNodes = new ArrayList<TreeNode>();

        if (parentNode != null) {
            adjacentNodes.add(parentNode);
        }

        if (isLeaf(node)) {
            graph.put(node, adjacentNodes);
            return;
        } else if (node.left == null && node.right != null) {
            adjacentNodes.add(node.right);
            buildGraph(node.right, node, graph);
        } else if (node.left != null && node.right == null) {
            adjacentNodes.add(node.left);
            buildGraph(node.left, node, graph);
        } else {
            adjacentNodes.add(node.left);
            adjacentNodes.add(node.right);
            buildGraph(node.left, node, graph);
            buildGraph(node.right, node, graph);
        }

        graph.put(node, adjacentNodes);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<TreeNode, List<TreeNode>>();
        buildGraph(root, null, graph);

        List<Integer> answer = new ArrayList<Integer>();

        LinkedList<TreeNode> frontier1 = new LinkedList<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        frontier1.add(target);

        while (k != 0) {
            int size = frontier1.size();
            LinkedList<TreeNode> frontier2 = new LinkedList<TreeNode>();

            for (int i = 0; i < size; i++) {
                TreeNode currNode = frontier1.poll();

                if (!visited.contains(currNode)) {
                    List<TreeNode> adjacentNodes = graph.get(currNode);
                    int sizeAdjacent = adjacentNodes.size();

                    for (int j = 0; j < sizeAdjacent; j++) {
                        if (!visited.contains(adjacentNodes.get(j))) {
                            frontier2.add(adjacentNodes.get(j));
                        }
                    }
                    
                    visited.add(currNode);
                }
            }

            frontier1 = frontier2;
            k--;
        }

        int size = frontier1.size();
        for (int i = 0; i < size; i++) {
            answer.add(frontier1.get(i).val);
        }

        return answer;
    }
}