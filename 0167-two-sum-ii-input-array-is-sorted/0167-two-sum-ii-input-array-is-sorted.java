class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pointer1 = 0;
        int pointer2 = numbers.length - 1;
        boolean found = false;
        int[] answer = new int[2];

        while(!found) {
            int total = numbers[pointer1] + numbers[pointer2];

            if (total == target) {
                answer[0] = pointer1 + 1;
                answer[1] = pointer2 + 1;
                return answer;
            } else if (total < target) {
                pointer1 += 1;
            } else if (total > target) {
                pointer2 -= 1;
            }
        }

        return answer;
    }
}