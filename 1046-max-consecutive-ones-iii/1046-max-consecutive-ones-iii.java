class Solution {
    public int longestOnes(int[] nums, int k) {
        int stationary = 0;
        int moving = 0;
        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        while (moving != nums.length) {
            if (nums[moving] == 0) {
                if (k == 0) {
                    while (nums[stationary] == 1) {
                        stationary++;
                        count--;
                    }
                    stationary++;
                    count--;
                    k++;
                } else if (k != 0) {
                    moving++;
                    k--;
                    count++;
                }
            } else if (nums[moving] == 1) {
                moving++;
                count++;
            }

            if (count > maxCount) maxCount = count;
        }

        return maxCount;
    }
}