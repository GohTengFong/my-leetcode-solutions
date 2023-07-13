class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;

        HashSet<String> dict = new HashSet<String>();
        for (String word : wordDict) dict.add(word);

        // stores whether or not workBreak is possible for the substring starting at index i
        boolean[] dp = new boolean[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
            
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length() - 1];
    }
}