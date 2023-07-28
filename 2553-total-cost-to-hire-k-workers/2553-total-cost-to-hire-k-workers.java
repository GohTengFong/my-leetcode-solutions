class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int front = 0;
        int end = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();

        long totalCost = 0;
        while (k != 0) {
            // continuously populates each PQ after every poll()
            while (pq1.size() < candidates && front <= end) {
                pq1.offer(costs[front++]);
            }
            while (pq2.size() < candidates && front <= end) {
                pq2.offer(costs[end--]);
            }

            int frontWorker = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE; // lowest cost worker in the front
            int endWorker = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE; // lowest cost worker in the back

            if (frontWorker <= endWorker) { // take front worker
                totalCost += frontWorker;
                pq1.poll();
            } else { // take back worker
                totalCost += endWorker;
                pq2.poll();
            }

            k--;
        }

        return totalCost;
    }
}