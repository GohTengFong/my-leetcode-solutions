class Solution {
	public int longestEqualSubarray(List<Integer> nums, int k) {
		int maxf = 0; 
		int i = 0;
		int n = nums.size();
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		for (int j = 0; j < n; j++) {
		    count.put(nums.get(j), count.getOrDefault(nums.get(j), 0) + 1);
		    maxf = Math.max(maxf, count.get(nums.get(j)));
		    if (j - i + 1 - maxf > k) {
		        count.put(nums.get(i), count.get(nums.get(i)) - 1);
		        i++;
		    }
		}
		return maxf;
	}
}