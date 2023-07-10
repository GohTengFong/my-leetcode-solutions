class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;
        
        while (i <= twoIndex) {
            if (nums[i] == 0) {
                int temp = nums[zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = temp;

                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[twoIndex];
                nums[twoIndex] = nums[i];
                nums[i] = temp;

                twoIndex--;
            } else {
                i++;
            }
        }
    }
}