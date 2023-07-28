class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

        for (int freq : map.values()) {
            if (set.contains(freq)) return false;
            else set.add(freq);
        }

        return true;
    }
}