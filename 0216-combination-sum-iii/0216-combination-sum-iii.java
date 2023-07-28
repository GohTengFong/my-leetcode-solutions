class Solution {
    private void dfs(ArrayList<List<Integer>> answer, int k, int target, int[] nums, int start, ArrayList<Integer> currList, int currSum) {
        if (k == 0 && currSum != target) return;
        else if (k < 0) return;
        
        if (k == 0 && currSum == target) {
            answer.add(new ArrayList<Integer>(currList));
        } else {
            for (int i = start; i < nums.length; i++) {
                currList.add(nums[i]);
                dfs(answer, k - 1, target, nums, i + 1, currList, currSum + nums[i]);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();

        dfs(answer, k, n, nums, 0, new ArrayList<Integer>(), 0);

        return answer;
    }
}