class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        if (target >= letters[end]) {
            return letters[0];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) { // recurse right
                start = mid + 1;
            } else if (letters[mid] > target) { // recurse left
                end = mid;
            }
        }

        return letters[end] == target ? letters[0] : letters[end];
    }
}