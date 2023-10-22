class Solution {
    public int minimumSum(int[] nums) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                int second = nums[j];

                for (int k = j + 1; k < nums.length; k++) {
                    int third = nums[k];
                    int sum = first + second + third;

                    if (first < second && third < second && sum < answer) answer = sum;
                }
            }
        }

        if (answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
}