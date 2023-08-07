class Solution {
    private boolean isPalindrome(String s) {
        char[] charS = s.toCharArray();

        int start = 0;
        int end = charS.length - 1;

        while (start <= end) {
            if (charS[start] != charS[end]) return false;

            start++;
            end--;
        }

        return true;
    }

    private void dfs(ArrayList<List<String>> answer, ArrayList<String> currList, String s) {
        if (s == null || s.length() == 0) {
            ArrayList<String> temp = new ArrayList<String>(currList);
            answer.add(temp);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);

            if (!isPalindrome(temp)) continue; // can only start exploring if the first substring is a palindrome

            currList.add(temp);
            dfs(answer, currList, s.substring(i, s.length())); // passing in a substring of s since the first substring is confirmed to be a palindrome
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        ArrayList<List<String>> answer = new ArrayList<List<String>>();
        ArrayList<String> currList = new ArrayList<String>();

        if (s.equals("")) {
            answer.add(currList);
            return answer;
        }

        dfs(answer, currList, s);

        return answer;
    }
}