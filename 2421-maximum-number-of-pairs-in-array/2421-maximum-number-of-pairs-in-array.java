class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] answer = new int[2];

        HashSet<Integer> have = new HashSet<Integer>();

        int numOfPairs = 0;
        for (int num : nums) {
            if (have.contains(num)) {
                have.remove(num);
                numOfPairs++;
            } else if (!have.contains(num)) {
                have.add(num);
            }
        }

        answer[0] = numOfPairs;
        answer[1] = have.size();

        return answer;
    }
}