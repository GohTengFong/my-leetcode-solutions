class Solution {
    public int longestContinuousSubstring(String s) {
        if (s.length() == 1) return 1;

        char[] charArray = s.toCharArray();
        StringBuilder window = new StringBuilder();
        int longest = Integer.MIN_VALUE;

        int prevChar = 0;
        int nextChar = 1;
        window.append(charArray[prevChar]);

        while (nextChar < charArray.length) {
            int prevAscii = charArray[prevChar] - 'a';
            int nextAscii = charArray[nextChar] - 'a';

            if (nextAscii - prevAscii == 1) {
                window.append(charArray[nextChar]);

                prevChar++;
                nextChar++;

                if (nextChar == charArray.length) {
                    if (window.length() > longest) longest = window.length();    
                }
            } else {
                if (window.length() > longest) longest = window.length();

                window = new StringBuilder();

                prevChar = nextChar;
                nextChar++;
                window.append(charArray[prevChar]);
            }
        }

        return longest;
    }
}