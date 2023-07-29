class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> answer = new ArrayList<int[]>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) { // interval < newInterval
                answer.add(interval);
            } else if (newInterval[1] < interval[0]) { // newInterval < interval
                answer.add(newInterval);
                newInterval = interval;
            } else { // need to merge
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        answer.add(newInterval); // adding the last interval

        return answer.toArray(new int[answer.size()][]);
    }
}