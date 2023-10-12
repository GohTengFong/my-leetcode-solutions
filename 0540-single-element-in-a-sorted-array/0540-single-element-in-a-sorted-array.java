class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            if (start == end) return nums[start];

            int midOne = start + (end - start) / 2; // represents first index at which nums[midOne] appears
            int midTwo = -1; // represents second index at which nums[midOne] appears
 
            int midNum = nums[midOne];

            System.out.println(midNum);

            if (nums[midOne - 1] == midNum) {
                midTwo = midOne;
                midOne = midOne - 1;
            } else if (nums[midOne + 1] == midNum) {
                midTwo = midOne + 1;
            } else {
                return midNum;
            }

            int leftSubArrLength = midOne - start;
            int rightSubArrLength = end - midTwo;

            if (leftSubArrLength % 2 != 0) { // search left subarray
                end = midOne - 1;
            } else { // search right subarray
                start = midTwo + 1;
            }
        }

        return -1;
    }
}

/*

Idea :
- binary search nums
- determine pair
- search odd lengthed subarray

*/