class Solution {
    public int[] applyOperations(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            }
        }

        for (int i = zeroIndex + 1; i < nums.length; i++) {
            while (nums[zeroIndex] != 0) {
                zeroIndex++;

                if (zeroIndex == nums.length) break;
            }

            if (zeroIndex == nums.length) break;
            else if (nums[i] == 0) continue;

            nums[zeroIndex] = nums[i];
            nums[i] = 0;
        }

        return nums;
    }
}