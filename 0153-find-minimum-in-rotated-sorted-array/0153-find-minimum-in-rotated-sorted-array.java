class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            }
        }

        return nums[start];
    }
}

/*

4, 5, 6, 7, 0, 1, 2
^        ^        ^
nums[mid] > nums[end]
- this indicates that left portion is sorted (including nums[mid])
- search right (do not need to consider nums[mid] since it is greater than nums[end])
- start = mid + 1

6, 7, 0, 1, 2, 4, 5
^        ^        ^
nums[mid] < nums[end] : search left
- this indicates that right portion is sorted (including nums[mid])
- search left (must have nums[mid] within subarray since it may be the smallest value in the sorted portion)
- end = mid

*/