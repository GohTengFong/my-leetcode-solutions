class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);
            answer = Math.max(max, answer);
        }

        return answer;
    }
}

/*

Idea :
- maintain 3 dp arrays
  1. max -> maximum product ending at nums[i]
  2. min -> minimum product ending at nums[i]
  3. ans -> maximum product subarray

num = [3, 2, -1,   5, -2]
min = [3, 2, -6, -30, -2]
max = [3, 6, -1,   5, 60]
ans = [3, 6,  6,   6, 60]

*/