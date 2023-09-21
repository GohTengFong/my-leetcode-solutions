class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        HashSet<Integer> seen = new HashSet<Integer>();

        for (int num : nums) {
            if (num > 0 && !seen.contains(num)) {
                minHeap.offer(num);
                seen.add(num);
            }
        }

        for (int i = 1; i <= nums.length + 1; i++) {
            if (minHeap.isEmpty()) return i;
            else if (minHeap.poll() != i) return i;
        }

        return -1;
    }
}