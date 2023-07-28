class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        double[] dp = new double[nums.length];
        
        int start = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 1) {
                dp[i] = 1;
                start = i;
                break;
            }
        }

        int count = 0;
        for (int i = start - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = (int) (dp[i + 1] % (Math.pow(10, 9) + 7));
                count++;
            } else if (nums[i] == 1) {
                count++;
                dp[i] = (int) ((dp[i + 1] * count) % (Math.pow(10, 9) + 7));
                count = 0;
            }
        }

        int answer = (int) (dp[0] % (Math.pow(10, 9) + 7));

        return answer;
    }
}