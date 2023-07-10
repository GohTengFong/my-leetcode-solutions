class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length - 1];

        StringBuilder longestPrefix = new StringBuilder();

        for (int i = 0; i < firstString.length(); i++) {
            if (firstString.charAt(i) == lastString.charAt(i)) {
                longestPrefix.append(firstString.charAt(i));
            } else {
                break;
            }
        }

        return longestPrefix.toString();
    }
}