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

/*

Idea :
- 2 main types of mismatch
- to swap as little as possible, resolve type 2 first
- iterate through s1 and s2 and stop when letters are not matching
	- iterate through the remaining letters in s1 and s2 to find another letters mismatch and s1Char[i] == s1Char[j]
		- this indicates a type 2
			- swap letters and increment swap by 1
	- if there are no such letter mismatch where s1Char[i] == s1Char[j]
		- this indicates that there are no more type 2, must look for type 1
		- iterate through the remaining letters in s1 and s2 to find another letter mismatch and s1Char[i] != s1Char[j]
			- this indicates a type 1
				- swap letters and increment swap by 2
  - if both mismatch types are unfound, no answer is possible, return -1

Mismatch Type 1 (2 swaps required)
s1 = xy
s2 = yx

Mismatch Type 2 (1 swap required)
s1 = xx
s2 = yy

*/