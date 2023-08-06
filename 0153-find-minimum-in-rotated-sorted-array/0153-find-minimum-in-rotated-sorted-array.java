class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int answer = nums[0];

        while (start <= end) {
            if (nums[start] < nums[end]) {
                answer = Math.min(answer, nums[start]);
                break;
            }

            int mid = start + (end - start) / 2;
            answer = Math.min(nums[mid], answer);

            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return answer;
    }
}