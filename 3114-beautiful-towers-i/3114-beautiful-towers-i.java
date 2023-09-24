class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long answer = Integer.MIN_VALUE;
        for (int index = 0; index < maxHeights.size(); index++) {
            int peak = maxHeights.get(index);
            long leftSum = 0;
            long rightSum = 0;
            long sum = 0;
            
            if (index != 0) { // need to iterate left
                int minSoFar = peak;
                
                for (int i = index - 1; i >= 0; i--) {
                    if (maxHeights.get(i) < minSoFar) {
                        minSoFar = maxHeights.get(i);
                        leftSum += minSoFar;
                    } else {
                        leftSum += minSoFar;
                    }
                }
            }
            
            if (index != maxHeights.size() - 1) { // need to iterate right
                int minSoFar = peak;
                
                for (int i = index + 1; i < maxHeights.size(); i++) {
                    if (maxHeights.get(i) < minSoFar) {
                        minSoFar = maxHeights.get(i);
                        rightSum += minSoFar;
                    } else {
                        rightSum += minSoFar;
                    }
                }
            }
            
            sum = leftSum + rightSum + maxHeights.get(index);
            answer = Math.max(answer, sum);
        }
        
        return answer;
    }
}