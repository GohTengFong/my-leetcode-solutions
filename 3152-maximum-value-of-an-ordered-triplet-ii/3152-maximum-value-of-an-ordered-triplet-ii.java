class Solution {
    public long maximumTripletValue(int[] nums) {
        long answer = 0;
        long i = 0;
        long ij = 0; // represents nums[i]- nums[j]

        for (int num : nums) {
            answer = Math.max(answer, 1L * ij * num);
            ij = Math.max(ij, i - num);
            i = Math.max(i, num);
        }

        return answer;
    }
}