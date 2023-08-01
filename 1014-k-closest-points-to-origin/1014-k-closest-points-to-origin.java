class Solution {
    private Double getDistance(int[] point) {
        return Math.pow(point[0], 2) + Math.pow(point[1], 2);
    }

    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1, p2) -> getDistance(p1).compareTo(getDistance(p2)));
        
        for (int[] point : points) minHeap.add(point);
        
        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) answer[i] = minHeap.poll();
        
        return answer;
    }
}