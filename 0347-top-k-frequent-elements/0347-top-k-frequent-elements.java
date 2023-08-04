class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        // [freq, num]
        // minHeap sorted by freq
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]); 
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            int[] pair = new int[] {freq, num};
            
            if (minHeap.size() < k) minHeap.offer(pair);
            else if (minHeap.size() == k && freq > minHeap.peek()[0]) {
                minHeap.poll();
                minHeap.offer(pair);
            }
        }

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = minHeap.poll()[1];
        }

        return answer;
    }
}