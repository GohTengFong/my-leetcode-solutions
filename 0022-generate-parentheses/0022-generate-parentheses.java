class Solution {
    private void dfs(ArrayList<String> answer, StringBuilder currString, int open, int close, int n) {
        if (currString.length() == n * 2) {
            answer.add(currString.toString());
            return;
        }

        if (open < n) {
            dfs(answer, currString.append("("), open + 1, close, n);
            currString.deleteCharAt(currString.length() - 1);
        }

        if (close < open) {
            dfs(answer, currString.append(")"), open, close + 1, n);
            currString.deleteCharAt(currString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> answer = new ArrayList<String>();
        StringBuilder currString = new StringBuilder();

        dfs(answer, currString, 0, 0, n);

        return answer;
    }
}