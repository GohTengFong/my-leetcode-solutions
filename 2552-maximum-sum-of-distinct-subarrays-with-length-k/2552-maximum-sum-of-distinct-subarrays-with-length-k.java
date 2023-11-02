class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long answer = 0;

        long windowSum = 0;
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();

        for (int start = 0, end = 0; end < nums.length; end++) {
            windowSum += nums[end];
            window.put(nums[end], window.getOrDefault(nums[end], 0) + 1);

            if (end >= k - 1) {
                if (window.size() == k) answer = Math.max(answer, windowSum);

                windowSum -= nums[start];
                window.put(nums[start], window.get(nums[start]) - 1);

                if (window.get(nums[start]) == 0) window.remove(nums[start]);

                start++;
            }
        }

        return answer;
    }
}