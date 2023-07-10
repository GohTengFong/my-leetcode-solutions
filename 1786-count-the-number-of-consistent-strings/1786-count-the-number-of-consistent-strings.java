class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;

        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            boolean encounter = false;

            for (int j = 0; j < currWord.length(); j++) {
                if (j == currWord.length() - 1 && set.contains(currWord.charAt(j))) {
                    encounter = true;
                } else if (!set.contains(currWord.charAt(j))) {
                    break;
                }
            }

            if (encounter) {
                count++;
            }
        }

        return count;
    }
}