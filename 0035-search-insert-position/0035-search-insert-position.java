class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        if (end < 0) {
            return 0;
        } else if (end == 0) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        if (nums[end] < target) {
            return end + 1;
        }

        return end;
    }
}