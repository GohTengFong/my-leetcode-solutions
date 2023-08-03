class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sumsOfSubArrays = new int[nums.length + 1];
        sumsOfSubArrays[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sumsOfSubArrays[i] = sumsOfSubArrays[i - 1] + nums[i - 1];
        }

        int answer = 0;

        for (int start = 0; start < sumsOfSubArrays.length; start++) {
            for (int end = start + 1; end < sumsOfSubArrays.length; end++) {
                if (sumsOfSubArrays[end] - sumsOfSubArrays[start] == k) answer++;
            }
        }

        return answer;
    }
}