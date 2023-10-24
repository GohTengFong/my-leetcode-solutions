class Solution {
    private int groupify(HashMap<Integer, Integer> freqMap, int size) {
        int groups = 0;
        
        for(int freq : freqMap.values()) {
            int numGroups = freq / (size + 1);
            int remainder = freq % (size + 1);

            // if remainder != 0, this will form a remainder group
            // some fullGroups must give 1 element to this remainder group until it has size elements
            // (size - remainder) represents the number of fullGroups that needs to be available to give 1 element to the remainder group
            // hence, if fullGroups < (size - remainder), there is not enough fullGroups
            // this size is not possible, return 0 immediately

            if (remainder == 0) groups += numGroups;
            else if (numGroups >= size - remainder) groups += numGroups + 1;
            else return 0;
        }

        return groups;
    }

    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        int minFreq = Integer.MAX_VALUE;
        for (int freq : freqMap.values()) minFreq = Math.min(freq, minFreq);

        // attempt to group into different sizes where each group size <= minFreq + 1
        for (int size = minFreq; size >= 1; size--) { 
            int numOfGroups = groupify(freqMap, size);
            if (numOfGroups > 0) return numOfGroups;
        }

        return -1;
    }
}