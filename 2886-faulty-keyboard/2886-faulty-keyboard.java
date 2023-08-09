class Solution {
    public String finalString(String s) {
        char[] charS = s.toCharArray();

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != 'i') answer.append(charS[i]);
            else if (charS[i] == 'i') answer.reverse();
        }

        return answer.toString();
    }
}