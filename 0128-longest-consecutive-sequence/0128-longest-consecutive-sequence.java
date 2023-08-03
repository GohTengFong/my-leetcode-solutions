class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>(); // contains all the num in nums 
        for (int num : nums) set.add(num);

        int longest = 0;

        // for each num in nums, check if the set contains numbers to the left and right of num
        // for each left and right number the set contains, increase currCount
        for (int num : nums) {
            int currCount = 1; // by default, include currNum
            int currNum = num - 1;

            // looking to the left of num
            while (set.contains(currNum)) {
                currCount++;
                set.remove(currNum); // to prevent looking at the same consecutive sequence
                currNum--;
            }

            currNum = num + 1; // resetting the value of currNum to look to the right
            while (set.contains(currNum)) {
                currCount++;
                set.remove(currNum);
                currNum++;
            }

            if (currCount > longest) longest = currCount;
        }

        return longest;
    }
}