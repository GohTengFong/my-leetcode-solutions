class Solution {
    private void combineArrays(int[] nums1, int[] nums2, int[] combined) {
        int oneIndex = 0;
        int twoIndex = 0;
        int combinedIndex = 0;

        while (oneIndex < nums1.length || twoIndex < nums2.length) {
            if (oneIndex >= nums1.length) {
                combined[combinedIndex] = nums2[twoIndex];
                twoIndex++;
                combinedIndex++;
                continue;
            }

            if (twoIndex >= nums2.length) {
                combined[combinedIndex] = nums1[oneIndex];
                oneIndex++;
                combinedIndex++;
                continue;                
            }

            if (nums1[oneIndex] <= nums2[twoIndex]) {
                combined[combinedIndex] = nums1[oneIndex];
                oneIndex++;
                combinedIndex++;
            } else {
                combined[combinedIndex] = nums2[twoIndex];
                twoIndex++;
                combinedIndex++;
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] combined = new int[length];
        combineArrays(nums1, nums2, combined);

        if (combined.length % 2 == 0) {
            int right = length / 2;
            int left = right - 1;

            double answer = ((double) combined[left] + combined[right]) / 2;

            return answer;
        } else {
            int index = length / 2;

            return combined[index];
        }
    }
}
