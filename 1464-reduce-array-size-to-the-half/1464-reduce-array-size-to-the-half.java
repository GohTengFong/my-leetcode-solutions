class Solution {
    private HashMap<Integer, Integer> createMap(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        
        for (int i : arr) freq.put(i, freq.getOrDefault(i, 0) + 1);

        return freq;
    }

    public int minSetSize(int[] arr) {
        int size = arr.length;
        int threshold = size / 2;
        int setSize = 0;

        HashMap<Integer, Integer> freq = createMap(arr);
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) maxHeap.offer(entry);
      
        while (!(size <= threshold)) {
            size -= maxHeap.poll().getValue();
            setSize += 1;
        }

        return setSize;
    }
}