class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        char[] charArray = pattern.toCharArray();

        HashMap<Character, String> charToS = new HashMap<Character, String>();
        HashMap<String, Character> sToChar = new HashMap<String, Character>();

        if (words.length != charArray.length) return false;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            String word = words[i];

            if (charToS.containsKey(c)) {
                if (!charToS.get(c).equals(word)) return false;
            }

            if (sToChar.containsKey(word)) {
                if (sToChar.get(word) != c) return false;
            }

            charToS.put(c, word);
            sToChar.put(word, c);
        }

        return true;
    }
}