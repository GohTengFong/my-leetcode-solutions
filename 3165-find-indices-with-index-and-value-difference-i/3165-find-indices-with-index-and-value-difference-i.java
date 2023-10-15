class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] answer = new int[] {-1, -1};
        
        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) < indexDifference) continue;
                
                int secondNum = nums[j];
                
                if (Math.abs(firstNum - secondNum) >= valueDifference) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}