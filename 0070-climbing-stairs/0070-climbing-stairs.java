class Solution {
    public int climbStairs(int n) {
        int oneStep = 1;
        int twoStep = 1;

        for(int i = 0; i < n - 1; i++) {
            int temp = oneStep;

            oneStep = oneStep + twoStep;
            twoStep = temp;
        }

        return oneStep;
    }
}