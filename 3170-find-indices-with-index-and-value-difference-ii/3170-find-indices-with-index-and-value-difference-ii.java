class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < nums.length; i++) {
            int[] pair = new int[] {nums[i], i};

            minHeap.offer(pair);
            maxHeap.offer(pair);
        }
        
        int[] answer = new int[] {-1, -1};
        for (int i = 0; i + indexDifference < nums.length; i++) {
            while (minHeap.size() > 0 && minHeap.peek()[1] < i + indexDifference) {
                minHeap.poll();
            }
            while (maxHeap.size() > 0 && maxHeap.peek()[1] < i + indexDifference) {
                maxHeap.poll();
            }

            if (minHeap.size() > 0 && Math.abs(nums[i] - minHeap.peek()[0]) >= valueDifference) {
                answer[0] = i;
                answer[1] = minHeap.peek()[1];
                return answer;
            }
            if (maxHeap.size() > 0 && Math.abs(nums[i] - maxHeap.peek()[0]) >= valueDifference) {
                answer[0] = i;
                answer[1] = maxHeap.peek()[1];
                return answer;                
            }
        }

        return answer;
    }
}

/*

Idea :
- maintain a minHeap and maxHeap sorted by nums[i]
- iterate through nums
  - trying to find 2 numbers that fit the 2 conditions
  - take nums[i] to be the first number
  - the second number must have index number >= i + indexDifference
  - enter a while-loop that pops every element whose index number < i + indexDifference
    - the second number is either the minimum element or maximum element left
    - the minimum element and the maximum element left will have index number >= indexDifference
      - this achieves condition 1
  - check if Math.abs(first number - second number) >= valueDifference
    - return immediately if condition 2 is achieved
    - else continue iterating nums

*/