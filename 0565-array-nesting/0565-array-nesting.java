class Solution {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(i)) continue;
            
            seen.add(i);
            int count = 1;

            int nextIndex = nums[i];
            while (!seen.contains(nextIndex)) {
                seen.add(nextIndex);
                nextIndex = nums[nextIndex];
                count++;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}

/*

Idea :
- maintain a set
- iterate through num : nums
- keep exploring until there is a duplicate in set
  - if there is a duplicate, it means there is a cycle
  - note that all other elements in this cycle would result in the same cycle and the same longest length
- continue to the next iteration
- do not explore if set contains num since it is a cycle that has been explored already

*/