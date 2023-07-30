class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;

        int[] currPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] nextPoint = points[i];

            if (i == points.length - 1) {
                if (currPoint[1] >= nextPoint[0]) {
                    count++;
                    break;
                } else {
                    count += 2;
                    break;
                }
            }

            if (currPoint[1] >= nextPoint[0]) {
                continue;
            } else {
                count++;
                currPoint = nextPoint;
            }
        }

        return count;
    }
}