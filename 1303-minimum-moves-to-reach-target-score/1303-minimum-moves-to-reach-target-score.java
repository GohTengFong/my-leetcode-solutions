class Solution {
    private int minMovesHelper(int target, int maxDoubles) {
        if (maxDoubles == 0) return target - 1;
        else if (target == 1) return 0;

        if (target % 2 == 0) {
            return 1 + minMovesHelper(target / 2, maxDoubles - 1);
        } else {
            return 1 + minMovesHelper(target - 1, maxDoubles);
        }
    }

    public int minMoves(int target, int maxDoubles) {
        return minMovesHelper(target, maxDoubles);
    }
}