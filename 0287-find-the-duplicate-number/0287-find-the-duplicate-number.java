class Solution {
    public int findDuplicate(int[] nums) {
        int fastPointer = 0;
        int slowPointer = 0;

        while (true) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
            fastPointer = nums[fastPointer];

            if (slowPointer == fastPointer) break;
        }

        slowPointer = 0;

        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }
}