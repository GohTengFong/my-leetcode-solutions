class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> charToVal = new HashMap<Character, Integer>();
        for (int i = 0; i < vals.length; i++) charToVal.put(chars.charAt(i), vals[i]);

        int maxEndingHere = 0;
        int maxEntirety = 0;

        for (int i = 0; i < s.length(); i++) {
            maxEndingHere = Math.max(maxEndingHere + charToVal.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1), 0);
            maxEntirety = Math.max(maxEndingHere, maxEntirety);
        }

        return maxEntirety;
    }
}