class Solution {
    // binarySearch over an inclusive range [left_boundary ~ right_boundary]
    private int binarySearch(int[] nums, int leftBoundary, int rightBoundary, int target) {
        int left = leftBoundary;
        int right = rightBoundary;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        
        // binarySearch for the index of the pivot element (the smallest element)
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[n - 1]) left = mid + 1;
            else right = mid - 1;
        }
    
        // binarySearch over elements on the pivot element's left
        int answer = binarySearch(nums, 0, left - 1, target);
        if (answer != -1) {
            return answer;
        }
        
        // Binary search over elements on the pivot element's right
        return binarySearch(nums, left, n - 1, target);
    }
}