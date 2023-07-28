class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] freqMap1 = new int[26];
        int[] freqMap2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            freqMap1[word1.charAt(i) - 'a'] += 1;
            freqMap2[word2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if ((freqMap1[i] == 0 && freqMap2[i] != 0) || (freqMap1[i] != 0 && freqMap2[i] == 0)) return false;
        }

        Arrays.sort(freqMap1);
        Arrays.sort(freqMap2);

        return Arrays.equals(freqMap1, freqMap2);
    }
}