class Solution {
    private void insertToHash(String string, HashMap<Character, Integer> hashMap) {
        for(int i = 0; i < string.length(); i++) {
            if (!hashMap.containsKey(string.charAt(i))) {
                hashMap.put(string.charAt(i), 1);
            } else {
                int oldValue = hashMap.get(string.charAt(i));

                hashMap.put(string.charAt(i), oldValue + 1);
            }
        }
    }


    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomHash = new HashMap<Character, Integer>();
        HashMap<Character, Integer> magHash = new HashMap<Character, Integer>();

        insertToHash(ransomNote, ransomHash);
        insertToHash(magazine, magHash);

        for(int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);

            if (!magHash.containsKey(key)) {
                return false;
            } else if (magHash.get(key) <= 0) {
                return false;
            } else {
                int oldValue = magHash.get(key);

                magHash.put(key, oldValue - 1);
            }
        }

        return true;
    }
}