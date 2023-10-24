class Solution {
    public int minimumSum(int[] nums) {
        int[] minLeft = new int[nums.length]; // minLeft[i] represents the minimum element to the left of nums[i], exclusive
        int[] minRight = new int[nums.length]; // minRight[i] represents the minimum element to the right of nums[i], exclusive

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) minLeft[i] = nums[i];
            else minLeft[i] = Math.min(minLeft[i - 1], nums[i - 1]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) minRight[i] = nums[i];
            else minRight[i] = Math.min(minRight[i + 1], nums[i + 1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > minLeft[i] && nums[i] > minRight[i]) {
                answer = Math.min(answer, minLeft[i] + nums[i] + minRight[i]);
            }
        }

        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }
}

/*

Idea :
- for num : nums, each num may be the peak
- for a peak, need the minimum element on it's left and minimum element on it's right
- create minLeft and minRight array
- for num : nums, treat num as the peak
- update answer only if a smaller mountain is found

*/