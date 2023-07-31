class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int threeSum = nums[i] + nums[start] + nums[end];

                if (threeSum == 0) {
                    ArrayList<Integer> triplet = new ArrayList<Integer>();
                    triplet.add(nums[i]);
                    triplet.add(nums[start]);
                    triplet.add(nums[end]);
                    answer.add(triplet);

                    start++;
                    while (nums[start] == nums[start - 1] && start < end) start++;
                } else if (threeSum > 0) {
                    end--;
                } else if (threeSum < 0) {
                    start++;
                }
            }
        }

        return answer;
    }
}