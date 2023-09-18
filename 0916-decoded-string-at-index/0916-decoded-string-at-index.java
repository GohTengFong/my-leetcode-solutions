class Solution {
    public String decodeAtIndex(String s, int k) {
        long decodedLength = 0;

        // calculating the total length of the decoded string
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                int repeat = c - '0';

                decodedLength *= repeat;
            } else {
                decodedLength++;
            }
        }

        // working backwards
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            
            if (Character.isDigit(c)) {
                decodedLength /= c - '0';
                k %= decodedLength;
            } else {
                if (k % decodedLength == 0) return Character.toString(c);

                decodedLength--;
            }
        }

        return null;
    }
}

/*

Idea :
- the decoded string will be repeating 
- character at index k will be equal to character at index (k % length) where length = total length of decoded string
- first calculate the decodedLength
- work backwards 
  - iterate from the end of the string
  - if it is a digit, reduce decodedLength and update k
  - if it is not a digit
    - if k == decodedLength, this means that the current character is the character to return
    - else, decrement decodedLength

*/