class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zero1 = 0;
        long sum2 = 0;
        int zero2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zero1++;
                sum1 += 1;
            } else {
                sum1 += num;
            }
        }

        for (int num : nums2) {
            if (num == 0) {
                zero2++;
                sum2 += 1;
            } else {
                sum2 += num;
            }
        }

        if (sum1 < sum2 && zero1 == 0) return -1;
        if (sum1 > sum2 && zero2 == 0) return -1;

        return Math.max(sum1, sum2);
    }
}

/*

Idea :
- find the minimum sum of both arrays
- find the number of zeros of both arrays
- if (sum1 < sum2 && zero1 == 0), that means that sum1 can never sum to sum2, return -1
- if (sum1 > sum2 && zero2 == 0), that means that sum2 can never sum to sum1, return -1
- return the maximum of both minimum sums
	- cannot return minimum since 0s can only be replaced by positive integers

*/