class Solution {
    public void moveZeroes(int[] nums) {
        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[pointer1] != 0 && nums[pointer2] != 0) {
                pointer1 += 1;
                pointer2 += 1;
            } else if (nums[pointer1] == 0 && nums[pointer2] != 0) {
                nums[pointer1] = nums[pointer2];
                nums[pointer2] = 0;
                pointer1 += 1;
                pointer2 += 1;
            } else {
                pointer2 += 1;
            }
        }
    }
}