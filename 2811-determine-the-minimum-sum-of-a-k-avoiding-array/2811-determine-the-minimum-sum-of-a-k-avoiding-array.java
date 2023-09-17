class Solution {
    public int minimumSum(int n, int k) {
        int sum = 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        int counter = 1;
        while (n != 0) {
            if (set.contains(counter)) {
                counter++;
            } else {
                sum += counter;
                set.add(k - counter);
                counter++;
                n--;
            }
        }

        return sum;
    }
}

/*

Idea :
- maintain a set of numbers that are not allowed
- maintain a counter that starts from 1
- add counter to array
- add (k - counter) into set
- perform while n != 0
*/