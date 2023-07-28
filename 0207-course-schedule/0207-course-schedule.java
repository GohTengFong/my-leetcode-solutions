class Solution {
    private void createGraph(int[][] prereq, HashMap<Integer, ArrayList<Integer>> graph) {
        for (int i = 0; i < prereq.length; i++) {
            int[] currPair = prereq[i];

            if (graph.containsKey(currPair[0])) {
                ArrayList<Integer> adjacent = graph.get(currPair[0]);
                adjacent.add(currPair[1]);
                graph.put(currPair[0], adjacent);
            } else {
                ArrayList<Integer> adjacent = new ArrayList<Integer>();
                adjacent.add(currPair[1]);
                graph.put(currPair[0], adjacent);
            }
        }
    }

    private boolean dfs(int course, HashMap<Integer, ArrayList<Integer>> graph, HashSet<Integer> visited) {
        
        if (visited.contains(course)) return false;
        else if (graph.get(course) == null) return true;

        visited.add(course);

        ArrayList<Integer> adjacent = graph.get(course);
        for (int i = 0; i < adjacent.size(); i++) {
            if (!dfs(adjacent.get(i), graph, visited)) return false;
        }

        visited.remove(course);
        graph.put(course, null);

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        createGraph(prerequisites, graph);

        HashSet<Integer> visited = new HashSet<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited)) return false;
        }

        return true;
    }
}