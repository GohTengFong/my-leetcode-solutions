class Solution {
    public List<String> summaryRanges(int[] nums) {
        List list = new ArrayList<String>();

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                if (i == start) {
                    list.add("" + nums[i]);
                } else {
                    list.add(nums[start] + "->" + nums[i]);
                }
            } else if (nums[i] + 1 == nums[i + 1]) {
                continue;
            } else if (nums[i] + 1 != nums[i + 1]) {
                if (i == start) {
                    list.add("" + nums[i]);
                    start = i + 1;
                } else {
                    list.add(nums[start] + "->" + nums[i]);
                    start = i + 1;
                }
            }
        }

        return list;
    }
}