class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int maxPairs = 0;
        HashMap<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (freqMap.containsKey(reversedWord)) {
                maxPairs += freqMap.get(reversedWord);
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        return maxPairs;
    }
}