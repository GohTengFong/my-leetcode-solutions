class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // replacing all num : nums where (num <= 0) or (num > n)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // second iteration to mark present numbers by using negative values
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); // abs since values may be marked negative already

            if (num > n) continue; // this means that num == n + 1, can ignore since handled by base case

            num--; // decrement since supposed array is 1-indexed

            if (nums[num] > 0) { // only mark is the value is positive (preventing double marking since values may be marked negative already)
                nums[num] = -1 * nums[num];
            }
        }

        // last iteration to find positive value and return (index + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i + 1;
        }

        return n + 1; // base case where 1 to n are all present
    }
}

/*

Idea :
- replace num : nums where (num <= 0) and (num > n) into n + 1
  - since we do not care about negative numbers
  - since num : nums MUST be in the range of 1 to n + 1
- iterate through the array
- for each num : nums
  - decrement num (since the supposed resultant is 1-indexed)
  - set the value at nums[num] to be negative
  - indexes with negative values indicate that the (index + 1) is present
    - (index + 1) due to 1-indexed
- iterate through nums again
  - if there is a positive value, that means that specific (index + 1) did not appear
    - (index + 1) due to 1-indexed

i        0 1 2 3
nums     3 4 -1 1
supposed 1 2 3 4

*/