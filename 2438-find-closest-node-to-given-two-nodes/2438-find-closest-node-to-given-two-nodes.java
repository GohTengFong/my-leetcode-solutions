class Solution {
    private void bfs(int[] edges, int start, int[] path) {
        HashSet<Integer> visited = new HashSet<Integer>();
        LinkedList<Integer> frontier = new LinkedList<Integer>();

        frontier.add(start);

        int hops = 0;
        while (!frontier.isEmpty()) {
            int currNode = frontier.poll();

            if (!visited.contains(currNode)) {
                int adjNode = edges[currNode];

                if (adjNode != -1) frontier.offer(adjNode);

                visited.add(currNode);
                path[currNode] = hops;
            }

            hops++;
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] node1Path = new int[edges.length]; // node1Path[i] represents the distance from node1 to node i
        int[] node2Path = new int[edges.length]; // node2Path[i] represents the distance from node2 to node i

        Arrays.fill(node1Path, Integer.MAX_VALUE);
        Arrays.fill(node2Path, Integer.MAX_VALUE);

        bfs(edges, node1, node1Path);
        bfs(edges, node2, node2Path);

        int smallestIndex = Integer.MAX_VALUE;
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < node1Path.length; i++) {
            int distanceTravelledByNode1 = node1Path[i];
            int distanceTravelledByNode2 = node2Path[i];

            int maxDistanceTravelled = Math.max(distanceTravelledByNode1, distanceTravelledByNode2);

            if (maxDistanceTravelled == Integer.MAX_VALUE) continue;

            if (maxDistanceTravelled < shortestDistance) { // a shorter path to another common node has been found
                shortestDistance = maxDistanceTravelled;
                smallestIndex = i;
            } else if (maxDistanceTravelled == shortestDistance && i < smallestIndex) { // a path of the same shortest length so far has been found, compare indexes
                smallestIndex = i;
            }
        }

        if (smallestIndex == Integer.MAX_VALUE) return -1;

        return smallestIndex;
    }
}