class Solution {
    private void backTrack(List<List<Integer>> answer, ArrayList<Integer> tempList, int[] candidates, int target, int start) {
        if (target < 0) return;
        else if (target == 0) answer.add(new ArrayList<Integer>(tempList));
        else { 
            for (int i = start; i < candidates.length; i++){
                tempList.add(candidates[i]);
                backTrack(answer, tempList, candidates, target - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        Arrays.sort(candidates);

        backTrack(answer, new ArrayList<Integer>(), candidates, target, 0);

        return answer;
    }
}