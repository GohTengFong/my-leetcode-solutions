class Solution {
    public int countWords(String[] words1, String[] words2) {
        int answer = 0;

        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }

        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String s = entry.getKey();
            int freq = entry.getValue();

            if (freq == 1 && map2.containsKey(s) && map2.get(s) == 1) answer++; 
        }

        return answer;
    }
}