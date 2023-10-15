class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] dp = new int[groups.length];

        dp[dp.length - 1] = 1; // base case
        for (int i = groups.length - 2; i >= 0; i--) {
            int currNum = groups[i];

            for (int j = i + 1; j < groups.length; j++) {
                if (groups[j] != currNum) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }

            if (dp[i] == 0) dp[i] = dp[i + 1];
        }

        ArrayList<String> answer = new ArrayList<String>();

        int length = 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == length) {
                answer.add(words[i]);
                length++;   
            }
        }

        Collections.reverse(answer);

        return answer;
    }
}