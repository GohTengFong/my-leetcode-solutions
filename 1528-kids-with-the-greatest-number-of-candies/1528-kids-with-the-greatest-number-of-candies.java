class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> answer = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;

        for (int i : candies) {
            if (i > max) max = i;
        }

        for (int i : candies) {
            if (i + extraCandies >= max) answer.add(true);
            else answer.add(false);
        }

        return answer;
    }
}