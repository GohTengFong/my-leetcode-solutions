class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int count = 0;
        while (true) {
            for (int i = 0; i < target.length(); i++) {
                if (!map.containsKey(target.charAt(i))) {
                    return count;
                } else if (map.get(target.charAt(i)) == 0) {
                    return count;
                } else {
                    map.put(target.charAt(i), map.get(target.charAt(i)) - 1);
                }
            }

            count++;
        }
    }
}