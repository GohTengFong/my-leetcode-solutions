class Solution {
    public int alternatingSubarray(int[] nums) {
        int stationary = 0;
        int moving = 0;
        int currMax = Integer.MIN_VALUE;
        int currCount = -1;
        
        while (moving != nums.length) {
            if (moving == nums.length - 1) {
                if (currCount > currMax) {
                    currMax = currCount;
                }
                
                moving++;
            } else if (nums[stationary] + 1 == nums[stationary + 1] && stationary == moving) {
                moving++;
                currCount = 2;

                if (currCount > currMax) currMax = currCount;
            } else if (stationary + 1 == moving && nums[moving + 1] == nums[stationary]) {
                stationary++;
                moving++;
                currCount++;

                if (currCount > currMax) currMax = currCount;
            } else if (stationary + 1 == moving && nums[moving + 1] != nums[stationary]) {
                stationary++;
                currCount = 0;
            } else {
                moving++;
                stationary++;
            }
        }
        
        return currMax;
    }
}