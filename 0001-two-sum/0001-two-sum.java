class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap storage = new HashMap();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int firstNumber = nums[i];
            int secondNumber = target - firstNumber;
            
            if (storage.containsKey(secondNumber)) {
                answer[0] = i;
                answer[1] = (Integer) storage.get(secondNumber);
                return answer;
            }

            storage.put(nums[i], i);
        }

        return answer;
    }
}