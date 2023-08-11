class Solution {
    // returns whether or not a node is safe (dfs would either reach a terminal node or a cycle)
    private boolean dfs(int start, int[][] graph, HashMap<Integer, Boolean> safe) {
        // if safe already contains start, it means that start is being revisited
        // return previously cached value
        if (safe.containsKey(start)) return safe.get(start);

        safe.put(start, false); // base case for every node before starting dfs, node is unsafe

        // for all the neighbours of start, check if they are safe nodes
        // if any are unsafe, return false
        // for-loop will not execute if start is a terminal node
        for (int neighbour : graph[start]) {
            if (!dfs(neighbour, graph, safe)) {
                return false;
            }
        }

        safe.put(start, true); // update cache, start is a safe node

        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int numOfNodes = graph.length;

        // safe serves as a cache and visited checker
        HashMap<Integer, Boolean> safe = new HashMap<Integer, Boolean>(); // key = node, value = whether or not the node is safe
        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i = 0; i < numOfNodes; i++) {
            if (dfs(i, graph, safe)) answer.add(i);
        }

        return answer;
    }
}