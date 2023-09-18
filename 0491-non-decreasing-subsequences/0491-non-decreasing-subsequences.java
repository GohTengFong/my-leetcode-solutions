class Solution {
    private void dfs(int[] nums, int index, ArrayList<Integer> currList, HashSet<List<Integer>> answer) {
        if (currList.size() >= 2) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currList);
            answer.add(temp);
        }

        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] >= currList.get(currList.size() - 1)) {
                currList.add(nums[i]);
                dfs(nums, i, currList, answer);
                currList.remove(currList.size() - 1);
            }
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> answer = new HashSet<List<Integer>>();

        if (nums.length == 1) return new ArrayList<List<Integer>>(answer);

        ArrayList<Integer> currList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            currList.add(nums[i]);
            dfs(nums, i, currList, answer);
            currList.remove(currList.size() - 1);
        }

        return new ArrayList<List<Integer>>(answer);
    }
}