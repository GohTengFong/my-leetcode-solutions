class Solution {
    private HashMap<Integer, ArrayList<Integer>> createGraph(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<Integer>());


        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        return graph;
    }

    private int dfs(HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited, int currNode) {
        if (visited.contains(currNode)) return 0;
        
        ArrayList<Integer> neighbours = graph.get(currNode);
        visited.add(currNode);
        int numOfNodes = 1;

        for (int neighbour : neighbours) {
            numOfNodes += dfs(graph, visited, neighbour);
        }

        return numOfNodes;
    }

    public long countPairs(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = createGraph(n, edges);
        HashSet<Integer> visited = new HashSet<Integer>();
        int remaining = n;
        long answer = 0;

        for (int i = 0; i < n; i++) {
            int numOfNodes = 0;

            if (visited.contains(i)) continue;
            else {
                numOfNodes += dfs(graph, visited, i);
                remaining -= numOfNodes;
                answer += (long) remaining * numOfNodes;
            }
        }

        return answer;
    }
}