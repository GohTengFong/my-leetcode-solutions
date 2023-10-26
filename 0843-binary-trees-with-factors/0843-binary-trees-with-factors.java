class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();

        Arrays.sort(arr);

        map.put(arr[0], 1L);
        for (int i = 1; i < arr.length; i++) {
            int root = arr[i];
            long numOfTrees = 1;

            for (Integer value1 : map.keySet()) {
                if (root % value1 == 0 && map.containsKey(root / value1)) {
                    numOfTrees += map.get(value1) * map.get(root / value1);
                }
            }

            map.put(root, numOfTrees);
        }

        
        long answer = 0;
        for (Long numOfTrees : map.values()) {
            answer += numOfTrees;
        }
        answer %= (Math.pow(10, 9) + 7);

        return (int) answer;
    }
}

/*

Idea :
- for each value : arr, treat it as a root
- maintain dp hashmap, rootValue : number of binary trees with root = rootValue
- sort arr
  - arr[0] can be stored immediately into the hashmap, arr[0] : 1
- for the remaining root : arr
  - maintain a count that represents the number of binary trees with root as the root, by default count = 1
  - iterate through values < root to find 2 values where value1 * value2 == root
    - if exists, increment count, count += map.get(value1) * map.get(arr[i] / value1)
    - after all iterations, map.put(root, count)
- iterate hashmap and sum all values in hashmap

    40
  4    10
2   2 2   5

    40
  4    10
2   2 5   2

     40
  10    4
2   5 2   2

     40
  10    4
5   2 2   2

*/