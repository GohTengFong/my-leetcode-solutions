class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];

        Arrays.sort(nums);

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];

            for (int j = 0; j < nums.length; j++) {
                int num = nums[j];
                
                if (query - num > 0) {
                    query -= num;
                } else if (query - num < 0) {
                    answer[i] = j;
                    query -= num;
                    break;
                } else if (query - num == 0) {
                    answer[i] = j + 1;
                    query -= num;
                    break;
                }
            }

            if (query > 0) answer[i] = nums.length;
        }

        return answer;
    }
}