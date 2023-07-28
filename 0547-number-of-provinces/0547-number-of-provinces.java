class Solution {
    private int dfs(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int node) {
        if (visited[node]) return 1;

        ArrayList<Integer> edges = graph.get(node);

        visited[node] = true;
        for (int i = 0; i < edges.size(); i++) {
            dfs(graph, visited, edges.get(i));
        }

        return 1;
    }

    private HashMap createGraph(int[][] isConnected) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();

        for (int row = 0; row < isConnected.length; row++) {
            graph.put(row, new ArrayList<Integer>());
            int[] edges = isConnected[row];
            
            for (int i = 0; i < edges.length; i++) {
                if (row == i) continue;
                else if (edges[i] == 1) graph.get(row).add(i);
            }
        }
        
        return graph;
    }

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        HashMap<Integer, ArrayList<Integer>> graph = createGraph(isConnected);
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i]) continue;
            else count += dfs(graph, visited, i);
        }

        return count;
    }
}