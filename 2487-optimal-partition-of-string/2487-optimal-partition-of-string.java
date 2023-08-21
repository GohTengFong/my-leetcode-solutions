class Solution {
    public int partitionString(String s) {
        char[] charArray = s.toCharArray();
        HashSet<Character> seen = new HashSet<Character>(); // to track the characters in the current partition

        int numOfPartitions = 0;

        for (int i = 0; i < charArray.length; i++) {
            char currChar = charArray[i];
            
            if (seen.contains(currChar)) { // repeated character, increase numOfPartitions, reset seen and begin tracking next partition
                numOfPartitions++;

                seen.clear();
                seen.add(currChar);
            } else if (!seen.contains(currChar)) {
                seen.add(currChar);
            }
        }

        if (!seen.isEmpty()) numOfPartitions++; // accounting for the last partition

        return numOfPartitions;
    }
}