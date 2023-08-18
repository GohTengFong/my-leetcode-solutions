class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a); // to be able to extract the max at every position
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>(); // maintains the elements in the current sliding window and their frequency

        int start = 0;
        int end = k - 1;

        if (k >= nums.length) { // sliding window size is greater than array
            int max = Integer.MIN_VALUE; // can just find the max value in the array and return immediately
            for (int num : nums) {
                if (num > max) max = num;
            }

            int[] answer = new int[1];
            answer[0] = max;

            return answer;
        } else { // sliding window can be moved
            for (int i = start; i <= end; i++) { // initialize starting maxHeap and window
                maxHeap.offer(nums[i]);
                window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
            }
        }

        ArrayList<Integer> temp = new ArrayList<Integer>();
        while (end != nums.length) { // moving the sliding window
            int currMax = maxHeap.peek(); // the max to be added in the current iteration

            if (window.containsKey(currMax)) { // sliding window contains currMax
                temp.add(currMax); // can just add it to temp and continue moving the sliding window
            } else if (!window.containsKey(currMax)) { // sliding window does not contain currMax
                while (!window.containsKey(maxHeap.peek())) maxHeap.poll(); // continuously remove the greatest element that is not in the sliding window

                currMax = maxHeap.peek();
                temp.add(currMax);
            }

            // moving the sliding window
            if (window.get(nums[start]) == 1) { // there is only 1 occurance of the element to be removed
                window.remove(nums[start]); // can just remove the mapping entirely
            } else if (window.get(nums[start]) > 1) { // there is >1 occurance of the element to be removed, the element appears elsewhere in the sliding window
                int newFreq = window.get(nums[start]) - 1; // decrease frequency by 1

                window.put(nums[start], newFreq);
            }
            start++;
            end++;
            if (end != nums.length) {
                if (window.containsKey(nums[end])) { // sliding window already has an occurance of the element to be added
                    int newFreq = window.get(nums[end]) + 1; // increase frequency by 1

                    window.put(nums[end], newFreq);
                } else {
                    window.put(nums[end], 1); // create new mapping
                }

                maxHeap.offer(nums[end]);
            }
        }

        // copying temp over to answer array
        int[] answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}