class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] lastFirst = new int[k * 2];
        int index = 0;
        int max = 0;

        // value of score if last k elements are taken
        int lastK = 0;
        for (int i = cardPoints.length - k; i < cardPoints.length; i++) {
            lastFirst[index] = cardPoints[i];
            index++;

            lastK += cardPoints[i];
        }

        // value of score if first k elements are taken
        int firstK = 0;
        for (int i = 0; i < k; i++) {
            lastFirst[index] = cardPoints[i];
            index++;
            
            firstK += cardPoints[i];
        }

        max = Math.max(firstK, lastK);

        // value of score if a mix of first and last elements are taken
        for (int i = 0; i + k - 1 < lastFirst.length; i++) {
            int mixK = 0;
            for (int j = i; j <= i + k - 1; j++) mixK += lastFirst[j];

            max = Math.max(max, mixK);
        }

        return max;
    }
}