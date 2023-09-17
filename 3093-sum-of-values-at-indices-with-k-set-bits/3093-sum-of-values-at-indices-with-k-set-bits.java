class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int answer = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            int oneCount = 0;
            int temp = i;
            
            while (temp != 0) {
                if ((temp & 1) == 1) oneCount++;
                
                temp >>= 1;
            }
                        
            if (oneCount == k) {
                answer += nums.get(i);
            }
        }
        
        return answer;
    }
}

/*

Idea :
- iterate through nums
- maintain a counter to count the number of 1s
- if (num & 1) == 1, increment counter
- num >> 1
- perform until num == 0

*/