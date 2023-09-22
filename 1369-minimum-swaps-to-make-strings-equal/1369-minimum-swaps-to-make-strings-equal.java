class Solution {
    public int minimumSwap(String s1, String s2) {
        if (s1.equals(s2)) return 0;

        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        int length = s1Char.length;

        int swaps = 0;
        for (int i = 0; i < length; i++) {
            if (s1Char[i] == s2Char[i]) {
                continue;
            } else {
                int nextMismatch = -1;
                for (int j = i + 1; j < length; j++) {
                    if (s1Char[j] != s2Char[j] && s1Char[i] == s1Char[j]) {
                        nextMismatch = j;

                        s1Char[nextMismatch] = s2Char[nextMismatch];
                        s2Char[i] = s1Char[i];
                        swaps++;
                        break;
                    }
                }

                if (nextMismatch == -1) {
                    for (int j = i + 1; j < length; j++) {
                        if (s1Char[j] != s2Char[j] && s1Char[i] != s1Char[j]) {
                            nextMismatch = j;
                            
                            s2Char[i] = s2Char[nextMismatch];
                            s2Char[nextMismatch] = s1Char[nextMismatch];
                            swaps += 2;
                            break;
                        }
                    }
                }

                if (nextMismatch == -1) return -1;
            }
        }

        return (swaps == 0) ? -1 : swaps;
    }
}