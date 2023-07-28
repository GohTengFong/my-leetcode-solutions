class Solution {
    // returns the number of changes along the current path
    private int dfs(ArrayList<ArrayList<Integer>> adj, boolean [] visited, int start) {
        int changes = 0;
        visited[start] = true;

        ArrayList<Integer> children = adj.get(start); // getting all children of 0

        for (int child : children) { // traversing all the children of 0 since they are the only ways to reach 0
            if (!visited[Math.abs(child)]) {
                changes += dfs(adj, visited, Math.abs(child)) + (child > 0 ? 1 : 0); // if child > 0, it means that there is a edge from start to child which needs to be reversed
            }
        }

        return changes;
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int [] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            adj.get(from).add(to);
            adj.get(to).add(-from);
        }

        boolean [] visited = new boolean[n];

        return dfs(adj, visited, 0);
    }
}