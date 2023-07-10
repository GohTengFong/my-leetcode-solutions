class Solution {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        } 

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                answer += nums[i];
            }
        }

        return answer;
    }
}