class Solution {
    private void dfs(ArrayList<String> answer, char[] digitsChar, String s, String[] dict) {
        if (s.length() == digitsChar.length) {
            answer.add(s);
        } else {
            int currStringLength = s.length();
            int currDigit = digitsChar[currStringLength] - '0';

            for (char letter : dict[currDigit].toCharArray()) {
                dfs(answer, digitsChar, s + Character.toString(letter), dict);
            }
        }

    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> answer = new ArrayList<String>();

        if (digits.length() == 0) return answer;

        char[] digitsChar = digits.toCharArray();
        String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        dfs(answer, digitsChar, "", dict);

        return answer;
    }
}