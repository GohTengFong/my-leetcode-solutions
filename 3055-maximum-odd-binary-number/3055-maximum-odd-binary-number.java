class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        
        int oneCount = 0;
        for (char c : charArray) {
            if (c == '1') oneCount++;
        }
        
        if (oneCount == 0) return s;
        
        oneCount--; // reserve 1 for the last bit

        for (int i = 0; i < charArray.length; i++) {
            if (i == charArray.length - 1) {
                charArray[i] = '1'; // set last bit as 1
            } else if (oneCount != 0) {
                charArray[i] = '1';
                oneCount--;
            } else if (oneCount == 0) {
                charArray[i] = '0';
            }
        }
        
        return new String(charArray);
    }
}