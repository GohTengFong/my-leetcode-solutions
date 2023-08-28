class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if (s.length() < t.length()) return result;

        int resultLength = Integer.MAX_VALUE; // represents the length of current result

        int need = t.length(); // represents the number of characters needed, double count duplicates
        int have = 0; // represents the number of need characters present in the sliding window

        // key = character, value = frequency
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
        
        for (char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0) + 1);

        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char ch = s.charAt(windowEnd);

            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if (tMap.containsKey(ch) && sMap.get(ch) <= tMap.get(ch)) { // ch is needed AND frequency in window <= frequency required (deals with double counting of duplicates)
                have++; // increment have
            }
            
            while (have == need) { // current sliding window has all the characters in t
                // updating result
                if (resultLength > windowEnd - windowStart + 1) { // previous sliding window is longer than current sliding window
                    resultLength = windowEnd - windowStart + 1; // update resultLength
                    result = s.substring(windowStart, windowEnd + 1); // update result
                }
                
                // move the sliding window by constantly removing until the first character that is needed is removed
                char charToRemove = s.charAt(windowStart);
                if (sMap.get(charToRemove) == 1) {
                    sMap.remove(charToRemove);
                } else {
                    sMap.put(charToRemove, sMap.get(charToRemove) - 1);
                }
                windowStart++;
                
                if (tMap.containsKey(charToRemove) && sMap.getOrDefault(charToRemove, 0) < tMap.get(charToRemove)) { // a character that is needed has been removed
                    have--; // decrement have
                }
            }
        }
        
        return result;
    }
}