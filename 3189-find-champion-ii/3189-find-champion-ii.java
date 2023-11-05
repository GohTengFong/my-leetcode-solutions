class Solution {
    public int findChampion(int n, int[][] edges) {
        HashSet<Integer> hasIncoming = new HashSet<Integer>();
        
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            
            hasIncoming.add(to);
        }
        
        int answer = -1;
        for (int i = 0; i < n; i++) {
            if (!hasIncoming.contains(i)) {
                if (answer == -1) answer = i;
                else if (answer != -1) return -1;
            }
        }
        
        return answer;
    }
}