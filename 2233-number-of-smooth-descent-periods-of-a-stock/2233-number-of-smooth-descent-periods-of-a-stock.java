class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] dp = new long[prices.length];
        dp[dp.length - 1] = 1; // base case

        long lengthCounter = 1; 

        for (int i = dp.length - 2; i >= 0; i--) {
            if (prices[i] - 1 == prices[i + 1]) {
                lengthCounter++;
                dp[i] = dp[i + 1] + lengthCounter;
            } else {
                dp[i] = dp[i + 1] + 1;
                lengthCounter = 1;
            }
        }

        return dp[0];
    }
}

/*

Idea :
- dp[i] = number of smooth descent periods starting at index i
- maintain lengthCounter which represents the current length of smooth descent
- iterate through prices, starting from the back
- if price[i] - 1 == price[i + 1]
  - lengthCounter++
  - dp[i] = dp[i + 1] + lengthCounter
- else
  - dp[i] = dp[i + 1] + 1 (+ 1 to include day i - 1 since 1 day is counted as a smooth descent)
  - lengthCounter = 1 (reset lengthCounter)

*/