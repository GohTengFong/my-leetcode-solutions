class Solution {
    private int pointsInsideCircle(int[][] points, int[] circle) {
        int centreX = circle[0];
        int centreY = circle[1];
        int radius = circle[2];

        int numOfPoints = 0;
        for (int[] point : points) {
            int pointX = point[0];
            int pointY = point[1];
            
            double distanceFromCentre = Math.abs((pointX - centreX) * (pointX - centreX)) + Math.abs((pointY - centreY) * (pointY - centreY));

            if (distanceFromCentre <= radius * radius) {
                numOfPoints++;
            }
        }

        return numOfPoints;
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int numOfQueries = queries.length;
        int[] answer = new int[numOfQueries];

        for (int i = 0; i < numOfQueries; i++) {
            int[] circle = queries[i];

            answer[i] = pointsInsideCircle(points, circle);
        }

        return answer;
    }
}