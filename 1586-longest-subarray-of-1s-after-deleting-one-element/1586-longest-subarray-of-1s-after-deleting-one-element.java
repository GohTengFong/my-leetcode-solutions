class Solution {
    public int longestSubarray(int[] nums) {
        int deleteCount = 1;
        int maxSize = 0;
        int currSize = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                start = i;
                break;
            }
        }

        int stationary = start;

        for (int moving = start; moving < nums.length; moving++) {
            if (nums[moving] == 0) {
                if (deleteCount > 0) {
                    deleteCount--;
                } else if (deleteCount == 0) {
                    while (nums[stationary] != 0) {
                        stationary++;
                    }
                    stationary++;
                    
                    currSize = moving - stationary;
                }
            } else if (nums[moving] == 1) {
                currSize++;
            }

            if (currSize > maxSize) maxSize = currSize;
        }

        if (deleteCount == 1 && start == 0) return maxSize - 1;

        return maxSize;
    }
}