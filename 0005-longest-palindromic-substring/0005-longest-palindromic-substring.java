class Solution {
    private boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();

        int start = 0;
        int end = charArray.length - 1;

        while (start <= end) {
            if (charArray[start] != charArray[end]) return false;

            start++;
            end--;
        }

        return true;
    }

    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        
        int[][] dp = new int[s.length()][s.length()];
        int longestLength = Integer.MIN_VALUE;
        int longestStartIndex = 0;
        int longestEndIndex = 0;

        for (int row = 0; row < s.length(); row++) {
            for (int col = 0; col < s.length(); col++) {
                if (row == col) dp[row][col] = 1;
            }
        }

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end < s.length(); end++) {
                if (charArray[start] == charArray[end]) {
                    if (isPalindrome(s.substring(start, end + 1))) {
                        int palindromeLength = end + 1 - start;
                        dp[start][end] = palindromeLength;

                        if (palindromeLength > longestLength) {
                            longestLength = palindromeLength;
                            longestStartIndex = start;
                            longestEndIndex = end;
                        }
                    }
                } else {
                    dp[start][end] = dp[start][end - 1];
                }
            }
        }

        return s.substring(longestStartIndex, longestEndIndex + 1);
    }
}