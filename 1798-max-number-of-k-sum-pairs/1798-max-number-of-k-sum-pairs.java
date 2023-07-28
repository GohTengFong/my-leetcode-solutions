class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int front = 0;
        int last = nums.length - 1;
        int count = 0;

        while (front < last) {
            if (nums[front] + nums[last] == k) {
                front++;
                last--;
                count++;
            } else if (nums[front] + nums[last] < k) {
                front++;
            } else if (nums[front] + nums[last] > k) {
                last--;
            }
        }

        return count;
    }
}