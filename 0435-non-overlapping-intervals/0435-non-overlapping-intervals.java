class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int[] currInterval = intervals[0];
        int removed = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];
            
            if (currInterval[1] == nextInterval[1]) {
                removed++;
            } else if (nextInterval[1] != currInterval[1]) {
                if (nextInterval[0] >= currInterval[1]) {
                    currInterval = nextInterval;
                } else {
                    removed++;
                }
            }
        }

        return removed;
    }
}