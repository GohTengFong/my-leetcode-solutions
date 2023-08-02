class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int secondMax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondMax) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                secondMax = Math.max(stack.pop(), secondMax);
            }

            stack.push(nums[i]);
        }

        return false;
    }
}