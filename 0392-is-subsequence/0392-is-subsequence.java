class Solution {
    public boolean isSubsequence(String s, String t) {
        int sPointer = 0;
        int tPointer = 0;

        while (sPointer < s.length()) {
            if (tPointer == t.length()) return false;

            if (s.charAt(sPointer) == t.charAt(tPointer)) {
                sPointer++;
                tPointer++;
            } else {
                tPointer++;
            }
        }

        return true;
    }
}