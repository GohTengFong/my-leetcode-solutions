class Solution {
    private void dfs(List<List<Integer>> rooms, List<Integer> startingKeys, boolean[] visited) {
        for (int i = 0; i < startingKeys.size(); i++) {
            int key = startingKeys.get(i);
            
            if (visited[key]) continue;

            visited[key] = true;

            List<Integer> nextKeys = rooms.get(key);

            dfs(rooms, nextKeys, visited);
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        List<Integer> startingKeys = rooms.get(0);
        visited[0] = true;

        dfs(rooms, startingKeys, visited);

        for (boolean visit : visited) {
            if (!visit) return false;
        }

        return true;
    }
}