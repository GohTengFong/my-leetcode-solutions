class Solution {
    public int arrayNesting(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
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