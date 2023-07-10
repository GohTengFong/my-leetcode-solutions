class Solution {
    public void reverseString(char[] s) {
        int backPointer = s.length - 1;

        for (int i = 0; i < s.length; i++) {
            if (i == backPointer) {
                return;
            } else {
                char temp = s[i];
                s[i] = s[backPointer];
                s[backPointer] = temp;
                backPointer -= 1;

                if (backPointer == i) {
                    return;
                }
            }
        }
    }
}