class Solution {
    public String getSmallestString(int n, int k) {
        // initialise a character array with all 'a' as base case
        char[] answer = new char[n];
        Arrays.fill(answer, 'a');
        k = k - n; // decrement target value to account for answer array having all 'a'

        int currChar = 0;
        while (k > 0) { // k > 0 indicates that some characters need to be increased from 'a' to other characters
            currChar = Math.min(25, k); // obtaining either the exact value to minus from k to obtain 0 or the maximum character value possible to minus from k (25, since answer array already has 'a')
            
            n--;  // decrement array pointer
            answer[n] += currChar; // increasing the last character from 'a' to another character
            
            k -= currChar; // decrement target value
        }

        return String.valueOf(answer);
    }
}