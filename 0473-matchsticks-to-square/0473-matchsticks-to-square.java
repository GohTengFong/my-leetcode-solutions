class Solution {
    private void reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // returns true if the matchsticks can form a square
    private boolean dfs(int[] matchsticks, int[] sums, int index, int length) {
        if (index == matchsticks.length) {
            if (sums[0] == length && sums[1] == length && sums[2] == length) return true;
            else return false;
        }

        // iterating through each side, trying to allocate matchsticks[index]
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > length) continue;

            sums[i] += matchsticks[index];

            // this would return true if matchsticks[index] has been allocated to the correct basket
            if (dfs(matchsticks, sums, index + 1, length)) return true;

            // else, backtrack since it is in the wrong basket, try the next basket
            sums[i] -= matchsticks[index];
        }

        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;

        int totalLength = 0;
        for (int length : matchsticks) totalLength += length;

        if (totalLength % 4 != 0) return false;

        int length = totalLength / 4;

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        return dfs(matchsticks, new int[4], 0, length);
    }
}