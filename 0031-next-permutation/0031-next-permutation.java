class Solution {
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void nextPermutation(int[] nums) {
        int pivot = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i;
                break;
            }
        }
        pivot--;

        if (pivot != -1) {
            int successor = -1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[pivot]) {
                    successor = i;
                    break;
                }
            }

            swap(nums, pivot, successor);
        }

        int start = pivot + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);

            start++;
            end--;
        }
    }
}

/*

Idea :
- find the pivot where the subarray to the right of this pivot is a non-increasing subarray
- starting from the end of nums, find the successor of nums[pivot]
- swap nums[pivot] and nums[successor]
- reverse the entire non-increasing subarray

*/