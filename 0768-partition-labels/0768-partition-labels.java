class Solution {
    public List<Integer> partitionLabels(String s) {
        ArrayList<Integer> answer = new ArrayList<Integer>();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // a hashmap that maps every character to the last index where they appear at in s
        char[] charS = s.toCharArray();
        for (int i = 0; i < charS.length; i++) map.put(charS[i], i);

        int maxIndexReached = 0;
        int maxIndexAdded = -1; // instantiated as -1 to account for 0 index

        // iterate through s and store maxIndexReached by the current partition
        // if any character's last appearing index is smaller than maxIndexReached, it means that all instances of it appears within the partition
        // once i == maxIndexReached, all characters within the current partition has been accounted for
        // add (maxIndexReached - maxIndexAdded) to answer to account for previously added partitions
        // update maxIndexAdded for future partitions to account for
        for (int i = 0; i < charS.length; i++) {
            char currChar = charS[i];

            maxIndexReached = Math.max(maxIndexReached, map.get(currChar));

            if (maxIndexReached == i) {
                answer.add(maxIndexReached - maxIndexAdded);
                maxIndexAdded = maxIndexReached;
            }
        }

        return answer;
    }
}