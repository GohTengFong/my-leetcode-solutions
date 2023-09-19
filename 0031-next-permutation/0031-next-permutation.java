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
- need to find the rightmost number that can be increased
- this allows us to find the next permutation with the smallest lexicographical increment
- find the pivot where the subarray to the right of this pivot is a non-increasing subarray (suffix)
  - non-increasing subarray means that it cannot be increased any further
  - if pivot == -1, the entire array is non-increasing, return the smallest lexicograpical permutation
- by swapping nums[pivot] with the smallest element in the suffix greater than it, it will increase the left subarray (prefix) by the smallest lexicographical increment
- since the prefix has been increased, the suffix must be made as low as possible
  - reverse the suffix

*/