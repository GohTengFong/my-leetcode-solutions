class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int longestChain = 1;
        int[] currPair = pairs[0];

        for (int[] nextPair : pairs) {
            if (currPair[1] < nextPair[0]) {
                longestChain++;
                currPair = nextPair;
            } else {
                continue;
            }
        }

        return longestChain;
    }
}