class Solution {
    private void dfs(ArrayList<List<Integer>> answer, ArrayList<Integer> currList, int[] nums) {
        if (currList.size() == nums.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currList);
            answer.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (currList.contains(nums[i])) continue;

            currList.add(nums[i]);
            dfs(answer, currList, nums);
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> answer = new ArrayList<List<Integer>>();
        ArrayList<Integer> currList = new ArrayList<Integer>();
        
        dfs(answer, currList, nums);

        return answer;
    }
}