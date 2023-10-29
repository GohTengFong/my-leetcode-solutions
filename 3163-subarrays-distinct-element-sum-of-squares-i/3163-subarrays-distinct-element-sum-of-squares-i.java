class Solution {
    public int sumCounts(List<Integer> nums) {
        int answer = 0;
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j <= nums.size(); j++) {
                List<Integer> subArray = nums.subList(i, j);
                
                HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
                for (int num : subArray) {
                    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                }
                
                answer += Math.pow(freqMap.size(), 2);
            }
        }
        
        return answer;
    }
}