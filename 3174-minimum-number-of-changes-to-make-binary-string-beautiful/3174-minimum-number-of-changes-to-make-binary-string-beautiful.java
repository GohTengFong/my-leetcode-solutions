class Solution {
    public int minChanges(String s) {
        int answer = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i + 1 < charArray.length; i += 2) {
            char char1 = charArray[i];
            char char2 = charArray[i + 1];

            if (char1 != char2) answer++;
        }

        return answer;
    }
}