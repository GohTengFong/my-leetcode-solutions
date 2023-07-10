class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];

            if (!set.contains(currNum)) {
                set.add(currNum);
            } else {
                return true;
            }
        }

        return false;
    }
}