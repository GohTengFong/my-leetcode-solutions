class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            long first = nums[i];
            
            for (int j = i + 1; j < nums.length; j++) {
                long second = nums[j];
                
                for (int k = j + 1; k < nums.length; k++) {
                    long third = nums[k];
                    
                    long temp = (first - second) * third;
                    if (temp > answer) answer = temp;
                }
            }
        }
        
        return answer;
    }
}