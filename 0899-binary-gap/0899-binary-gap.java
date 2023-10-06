class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);

        int start = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                start = i;
                break;
            }
        }

        int maxLength = 0;
        for (int i = start + 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                int currLength = i - start;

                maxLength = Math.max(currLength, maxLength);

                start = i;
            }
        }

        return maxLength;
    }
}