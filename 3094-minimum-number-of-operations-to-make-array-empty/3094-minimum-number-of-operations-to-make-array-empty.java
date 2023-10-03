class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        int answer = 0;
        for (int freq : map.values()) {
            if (freq == 1) return -1;

            answer += (freq / 3) + (freq % 3 != 0 ? 1 : 0);
        }

        return answer;
    }
}

/*

Idea :
- maintain a hashmap, num : freq
- populate hashmap
- iterate through hashmap
- if (freq == 1)
  - return -1
- if (freq % 3 == 0)
  - answer += freq / 3
- if (freq % 3 == 1) 
  - answer += (freq / 3) + 1
    - 10 = 3, 3, 2, 2
- if (freq % 3 == 2)
  - answer += (freq / 3) + 1
    - 11 = 3, 3, 3, 2

*/