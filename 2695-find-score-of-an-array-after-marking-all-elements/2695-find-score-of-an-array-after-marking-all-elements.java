class Solution {
    public long findScore(int[] nums) {
        if (nums.length == 1) return nums[0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // sort by num first
                else return a[1] - b[1]; // sort by index second
            }
        );
        for (int i = 0; i < nums.length; i++) {
            int[] pair = new int[] {nums[i], i};
            minHeap.offer(pair);
        }

        long score = 0;
        while (!minHeap.isEmpty()) {
            int[] currPair = minHeap.poll();
            int num = currPair[0];
            int index = currPair[1];

            if (nums[index] == -1) continue;

            score += num;
            nums[index] = -1;

            if (index == 0) {
                nums[index + 1] = -1;
            } else if (index == nums.length - 1) {
                nums[index - 1] = -1;
            } else {
                nums[index + 1] = -1;
                nums[index - 1] = -1;
            }
        }

        return score;
    }
}