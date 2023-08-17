class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            valToIndex.put(val, i);
        }

        for (int[] op : operations) {
            int from = op[0];
            int to = op[1];

            int index = valToIndex.get(from);

            valToIndex.put(to, index);

            valToIndex.remove(from);
        }

        for (Map.Entry<Integer, Integer> entry : valToIndex.entrySet()) {
            int val = entry.getKey();
            int index = entry.getValue();

            nums[index] = val;
        }

        return nums;
    }
}