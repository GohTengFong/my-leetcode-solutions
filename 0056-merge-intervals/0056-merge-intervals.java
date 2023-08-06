class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            int[][] answer = new int[1][2];
            answer[0] = intervals[0];
            return answer;
        }
        
        ArrayList<int[]> temp = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int moving = 1;
        int[] currStationary = intervals[0];
        int[] currMoving = intervals[moving];

        while (moving != intervals.length) {
            if (currStationary[1] >= currMoving[0]) {
                int newX = Math.min(currStationary[0], currMoving[0]);
                int newY = Math.max(currStationary[1], currMoving[1]);
                currStationary = new int[] {newX, newY};

                moving++;

                if (moving == intervals.length) {
                    temp.add(currStationary);
                    break;
                } else {
                    currMoving = intervals[moving];
                }
            } else {
                temp.add(currStationary);
                currStationary = currMoving;
                
                moving++;

                if (moving == intervals.length) {
                    temp.add(currStationary);
                    break;
                } else {
                    currMoving = intervals[moving];
                }
            }
        }

        int[][] answer = new int[temp.size()][2];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}

/*

1,4 2,3 8,10 5,8

2,3 1,4 5,8 8,10

compare if a[1] >= b[0]
if yes -> take[min, max]
if no -> add a to answer


*/