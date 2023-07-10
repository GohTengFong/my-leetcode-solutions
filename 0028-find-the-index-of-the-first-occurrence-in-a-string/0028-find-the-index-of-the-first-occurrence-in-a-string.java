class Solution {
    private boolean checkRemaining(String haystack, String needle, int index) {
        for (int i = 0; i < needle.length(); i++) {
            if (index >= haystack.length()) {
                return false;
            }

            if (haystack.charAt(index) == needle.charAt(i)) {
                index += 1;
            } else {
                return false;
            }
        }

        return true;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean remaining = checkRemaining(haystack, needle, i);

                if (remaining) {
                    return i;
                }
            }
        }

        return -1;    
    }
}