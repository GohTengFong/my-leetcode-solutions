class Solution {
    private int[] findDominant(List<Integer> nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = Integer.MIN_VALUE;
        int dominant = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                dominant = entry.getKey();
            }
        }

        return new int[] {dominant, maxFreq};
    }

    public int minimumIndex(List<Integer> nums) {
        int[] domAndFreq = findDominant(nums);
        int dominant = domAndFreq[0];
        int totalFreq = domAndFreq[1];

        int leftFreq = 0;
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            int lengthOfLeft = i + 1;
            int lengthOfRight = nums.size() - lengthOfLeft;

            if (num == dominant) leftFreq++;

            if (leftFreq * 2 > lengthOfLeft) {
                int rightFreq = totalFreq - leftFreq;

                if (rightFreq * 2 > lengthOfRight) return i;
            }
        }

        return -1;
    }
}