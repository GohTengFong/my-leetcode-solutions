class Solution {
    private HashMap<String, HashMap<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap<String, HashMap<String, Double>>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String from = equation.get(0);
            String to = equation.get(1);
            double edgeWeight = values[i];
            double reverseEdgeWeight = 1 / edgeWeight;

            graph.putIfAbsent(from, new HashMap<String, Double>());
            graph.get(from).put(to, edgeWeight);

            graph.putIfAbsent(to, new HashMap<String, Double>());
            graph.get(to).put(from, reverseEdgeWeight);
        }

        return graph;
    }

    private double dfs(HashMap<String, HashMap<String, Double>> graph, String from, String to, HashSet<String> visited) {
        if (!graph.containsKey(from)) return -1.0;

        if (graph.get(from).containsKey(to)) return graph.get(from).get(to);

        visited.add(from);
        double weight = -1.0;
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            if (!visited.contains(entry.getKey())) {

                weight = dfs(graph, entry.getKey(), to, visited);

                if (weight != -1.0) return entry.getValue() * weight;
            }
        }

        return weight;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = createGraph(equations, values);

        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> currQuery = queries.get(i);
            String from = currQuery.get(0);
            String to = currQuery.get(1);
            
            answer[i] = dfs(graph, from, to, new HashSet<String>());
        }

        return answer;
    }
}