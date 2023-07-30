class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        int[][] dp = new int[char1.length + 1][char2.length + 1];

        for (int i = char1.length - 1; i >= 0; i--) {
            for (int j = char2.length - 1; j >= 0; j--) {
                if (char1[i] == char2[j]) dp[i][j] = 1 + dp[i + 1][j + 1]; // going diagonal
                else dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]); // going right and down
            }
        }

        return dp[0][0];
    }
}