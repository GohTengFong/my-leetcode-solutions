class Solution {
    public int takeCharacters(String s, int k) {
        char[] charArray = s.toCharArray();

        int[] count = new int[3];
        for (char c : charArray) count[c - 'a']++;

        for (int freq : count) {
            if (freq < k) return -1;
        }

        // moving the excluding window
        int excluded = 0;
        for (int start = 0, end = 0; end < charArray.length; end++) {
            char c = charArray[end]; // current char to be excluded

            count[c - 'a']--; // decrementing it's frequency

            if (count[c - 'a'] < k) { // the current char has been excluded too many times
                while (count[c - 'a'] < k) {
                    char addBack = charArray[start];
                    count[addBack - 'a']++;
                    start++;
                }
            }

            excluded = Math.max(excluded, end - start + 1);
        }

        return charArray.length - excluded;
    }
}

/*

Idea :
- maintain count which represents the frequency of each character
- iterate through s once to count the frequency of each character
- if any of the frequencies < k, return -1
- for each frequency, (frequency - k) represents the number of each character that can be excluded
- slide this exclusion window
	- problem becomes "longest substring where each character occurs a maximum of (frequency - k) times"
- maintain start which represents the start of the sliding window
- maintain end which represents the end of the sliding window
- as end is incremented, decrement the frequency of the character encountered
- if frequency < k, that means that too many of that character has been excluded
	- increment start until frequency == k
- constantly update longest excluded length
- return (length of s - longest excluded length)

*/