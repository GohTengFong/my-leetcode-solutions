class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            if (index == nums.length) continue;

            if (nums[index] < 0) {
                answer.add(index + 1);
                continue;
            } else {
                nums[index] = -1 * nums[index];
            }
        }

        return answer;
    }
}