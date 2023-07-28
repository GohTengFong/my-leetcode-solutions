class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = 0;
        double totalSum = 0;
        for (int i = 0; i < k; i++) {
            totalSum += nums[i];
        }
        maxAverage = totalSum / k;

        for (int i = k; i < nums.length; i++) {
            totalSum -= nums[i - k];
            totalSum += nums[i];

            double currAverage = totalSum / k;

            if (currAverage > maxAverage) maxAverage = currAverage;
        }

        return maxAverage;
    }
}