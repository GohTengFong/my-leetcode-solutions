class Solution {
    public int removeDuplicates(int[] nums) {
        int counter = 1;
        int firstPointer = 0;
        int secondPointer = 1;

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (secondPointer >= nums.length) {
                return counter;
            } else if (nums[secondPointer] == nums[firstPointer]) {
                secondPointer += 1;
            } else {
                nums[firstPointer + 1] = nums[secondPointer];
                secondPointer += 1;
                firstPointer += 1;
                counter += 1;
            }
        }

        return counter;
    }
}