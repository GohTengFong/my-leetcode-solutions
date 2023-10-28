class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int answer = Integer.MAX_VALUE;
        int windowSum = 0;

        while (end < nums.length) {
            windowSum += nums[end];
            end++;
            
            while (windowSum >= target) {
                answer = Math.min(answer, end - start);

                windowSum -= nums[start];
                start++;
            }
        }

        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}