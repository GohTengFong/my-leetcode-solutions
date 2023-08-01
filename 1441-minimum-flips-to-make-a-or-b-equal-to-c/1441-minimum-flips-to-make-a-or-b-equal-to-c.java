class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while (a > 0 || b > 0 || c > 0) {
            // obtaining the last bit of each number
            int bitA = a & 1;
            int bitB = b & 1;
            int bitC = c & 1;

            if (bitC == 0) {
                // if the last bit of c is 0, then the last bit of a and b must be 0
                // flip += 1 for each last bit of a and b that is not zero
                flips += (bitA + bitB); 
            } else {
                // if last bit of c is 1, then the last bit of either a and b, or both must be 1
                // if both are zero, either one must be flipped
                if (bitA == 0 && bitB == 0) flips += 1; 
            }

            // right shift operation for each number
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return flips;
    }
}