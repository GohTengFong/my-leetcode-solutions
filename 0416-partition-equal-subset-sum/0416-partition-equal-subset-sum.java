class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 != 0) return false; // check if the total sum of nums can even be divided by 2

        int target = sum / 2; // the target sum for each half of the partition

        HashSet<Integer> set1 = new HashSet<Integer>(); // stores every possible sum of the subarray starting from the back
        set1.add(0);

        // iterate through nums starting from the back
        for (int i = nums.length - 1; i >= 0; i--) {
            int currNum = nums[i];
            HashSet<Integer> set2 = new HashSet<Integer>(); // used to store the updated sum of subarray starting from the back, prevents set1 from iterating over itself

            for (Integer value : set1) {
                if (currNum + value == target) return true; // if there is a subarray sum + nums[i] that equals target that means that it is possible to partition nums

                // else add to set2
                set2.add(value); 
                set2.add(nums[i] + value);
            }

            set1 = set2; // replace set1 with set2
        }

        return false;
    }
}