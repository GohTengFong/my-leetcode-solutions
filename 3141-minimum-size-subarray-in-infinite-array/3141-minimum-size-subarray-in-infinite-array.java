class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int answer = (target / totalSum) * nums.length;
        
        target %= totalSum;

        int minSize = Integer.MAX_VALUE;
        int currSum = 0;
        for (int start = 0, end = 0; end < nums.length * 2; end++) {
            int endIndex = end % nums.length;
            int num = nums[endIndex];

            currSum += num;

            while (currSum > target) {
                int startIndex = start % nums.length;
                currSum -= nums[startIndex];
                start++;
            }

            if (currSum == target && end - start + 1 < minSize) minSize = end - start + 1;
        }

        if (minSize == Integer.MAX_VALUE) return -1;

        return answer + minSize;
    }
}