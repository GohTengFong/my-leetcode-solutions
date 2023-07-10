class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currMax = 0;
        int slowPointer = 0;
        int fastPointer = 0;
        HashSet<Character> set = new HashSet<Character>();

        while (fastPointer < s.length()) {
            if (!set.contains(s.charAt(fastPointer))) {
                set.add(s.charAt(fastPointer));
                fastPointer++;
                currMax = Math.max(currMax, set.size());
            } else {
                set.remove(s.charAt(slowPointer));
                slowPointer++;
            }
        }

        return currMax;
    }
}