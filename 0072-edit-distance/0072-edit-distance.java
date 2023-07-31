class Solution {
    private void fillBaseCases(int[][] dp, int word1Length, int word2Length) {
        for (int i = 0; i < word1Length; i++) dp[i][word2Length] = word1Length - i;

        for (int i = 0; i < word2Length; i++) dp[word1Length][i] = word2Length - i;
    }

    public int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        int[][] dp = new int[char1.length + 1][char2.length + 1];

        fillBaseCases(dp, char1.length, char2.length);

        for (int i = char1.length - 1; i >= 0; i--) {
            for (int j = char2.length - 1; j >= 0; j--) {
                if (char1[i] == char2[j]) dp[i][j] = dp[i + 1][j + 1];
                else dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
            }
        }

        return dp[0][0];
    }
}