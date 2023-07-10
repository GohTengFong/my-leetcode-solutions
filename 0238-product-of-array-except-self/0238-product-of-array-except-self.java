class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        // calculating prefix and inserting them into answer array
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // multiplying prefix by postfix to obtain the correct value
        int postFix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * postFix;
            postFix *= nums[i];
        }

        return answer;
    }
}