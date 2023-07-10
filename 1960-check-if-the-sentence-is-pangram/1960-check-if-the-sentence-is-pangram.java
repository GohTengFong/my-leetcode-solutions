class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] appear = new boolean[26];

        for (int i = 0; i < sentence.length(); i++) {
            char currChar = sentence.charAt(i);

            appear[currChar - 'a'] = true;
        }

        for (int i = 0; i < appear.length; i++) {
            if (!appear[i]) {
                return false;
            }
        }

        return true;
    }
}