class Solution {
    public int[] findOriginalArray(int[] changed) {
        int totalLength = changed.length;

        if (totalLength % 2 != 0) return new int[0];

        int actualLength = totalLength / 2;
        ArrayList<Integer> temp = new ArrayList<Integer>();

        Arrays.sort(changed);
        HashMap<Integer, Integer> lookFor = new HashMap<Integer, Integer>();

        for (int num : changed) {
            if (lookFor.containsKey(num)) {
                if (lookFor.get(num) == 1) lookFor.remove(num);
                else lookFor.put(num, lookFor.get(num) - 1);

                temp.add(num / 2);
            } else {
                lookFor.put(num * 2, lookFor.getOrDefault(num * 2, 0) + 1);
            }
        }

        if (!lookFor.isEmpty()) return new int[0];

        int[] answer = new int[actualLength];
        for (int i = 0; i < actualLength; i++) {
            answer[i] = temp.get(i);
        }
        
        return answer;
    }
}

/*

Idea :
- sort the array
- maintain a hashmaps, value : freq
- iterate through the array
- for each value, check if it exists in lookFor
  - if it does not exist, add (value * 2) to lookFor
  - if it exists, remove it from lookFor and add (value / 2) to answer
- after all iterations, hashmap should be empty

*/