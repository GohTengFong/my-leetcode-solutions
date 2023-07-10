class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int maxCount = 0;
        int maxKey = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);

                if (1 > maxCount) {
                    maxCount = 1;
                    maxKey = nums[i];
                }
            } else {
                int oldValue = map.get(nums[i]);

                map.put(nums[i], oldValue + 1);

                int newValue = map.get(nums[i]);

                if (newValue > maxCount) {
                    maxCount = newValue;
                    maxKey = nums[i];
                }
            }
        }

        return maxKey;
    }
}