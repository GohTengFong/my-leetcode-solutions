class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int largest1 = m - 1;
        int largest2 = n - 1 ;
        int largestTotal = nums1.length - 1;

        while (largest2 >= 0) {
            if (largest1 >= 0 && nums1[largest1] > nums2[largest2]) {
                nums1[largestTotal] = nums1[largest1];
                largestTotal--; 
                largest1--;
            } else {
                nums1[largestTotal] = nums2[largest2];
                largestTotal--; 
                largest2--;
            }
        }
    }
}