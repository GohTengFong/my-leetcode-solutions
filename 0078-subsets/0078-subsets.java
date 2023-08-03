class Solution {
    private void dfs(int startIndex, int[] nums, ArrayList<List<Integer>> answer, ArrayList<Integer> currList) {
        answer.add(new ArrayList<Integer>(currList));

        for (int i = startIndex; i < nums.length; i++) {
            currList.add(nums[i]);
            dfs(i + 1, nums, answer, currList);
            currList.remove(currList.size() - 1);
        }

    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> currList = new ArrayList<Integer>();

        dfs(0, nums, answer, currList);

        return answer;
    }
}