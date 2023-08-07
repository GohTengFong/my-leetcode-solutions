class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int startIndex = 0; // indicates the start of the sliding window
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>(); // char, freq
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>(); // char, freq
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        // add all characters and their frequencies in p to pMap
        for (char c : p.toCharArray()) pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        
        for (int i = 0; i < s.length(); i++) {
            // add all characters and their frequencies in s to sMap
            sMap.put(s.charAt(i), 1 + sMap.getOrDefault(s.charAt(i), 0));
            
            // only start comparing for anagrams when sMap has at least the same number of elements as pMap
            if (i >= p.length() - 1) {
                if (sMap.equals(pMap)) res.add(startIndex); // if both hashmaps are equal, that indicates an anagram
                
                // maintaining the size of the sliding window
                if (sMap.containsKey(s.charAt(startIndex))) {
                    sMap.put(s.charAt(startIndex), sMap.get(s.charAt(startIndex)) - 1); // removes the first element in the sliding window at i increments

                    if(sMap.get(s.charAt(startIndex)) == 0) sMap.remove(s.charAt(startIndex)); // if the frequency is 0, remove the element
                }

                startIndex += 1;
            }
        }
        
        return res;
    }
}