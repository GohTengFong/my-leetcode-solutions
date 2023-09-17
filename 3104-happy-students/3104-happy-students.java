class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);

        int answer = nums.get(0) > 0 ? 1 : 0;

        for (int i = 0; i < nums.size() - 1; i++) {
            if (i + 1 > nums.get(i) && i + 1 < nums.get(i + 1)) {
                answer++;
            }
        }

        if (nums.get(nums.size() - 1) < nums.size()) answer++;

        return answer;
    }
}

/*

Idea :

i    0 1 2 3 4 5 6 7 
nums 0 2 3 3 6 6 7 7 (student threshold)
- (i + 1) can be regarded as the number of students selected
- nums.get(i) is the value that (i + 1) must be greater than due to condition 1
- if (i + 1) > nums.get(i) this means that we can select the ith student and students before the ith student will all be selected and happy since the number of students selected is greater than the maximum student threshold so far
- if (i + 1) < nums.get(i + 1) this means that we can select the ith student and students after the ith student will all be unselected and happy since the number of students selected is smaller than the minimum student threshold so far

*/