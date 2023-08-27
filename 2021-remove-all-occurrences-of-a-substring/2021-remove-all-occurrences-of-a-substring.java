class Solution {
    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);

        int windowSize = part.length();

        int i = 0;
        while (i + windowSize <= sb.length()) {
            if (sb.substring(i, windowSize + i).equals(part)) {
                sb.delete(i, windowSize + i);
                i = 0;
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}