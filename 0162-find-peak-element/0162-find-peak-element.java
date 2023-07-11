class Solution {
    private boolean isPeak(int[] nums, int index) {
        if (index == 0) {
            if (nums[index] > nums[index + 1]) return true;
            else return false;
        } else if (index == nums.length - 1) {
            if (nums[index] > nums[index - 1]) return true;
            else return false;
        } else if (nums[index] > nums[index - 1] && nums[index] > nums[index + 1]) {
            return true;
        }

        return false;
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isPeak(nums, mid)) {
                return mid;
            } else if (nums[mid + 1] > nums[mid]) {
                start = mid + 1;
            } else if (nums[mid + 1] < nums[mid]) {
                end = mid - 1;
            }
        }

        return -1;
    }
}