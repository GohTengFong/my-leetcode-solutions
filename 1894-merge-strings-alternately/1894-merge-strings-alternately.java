class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int indexOne = 0;
        int indexTwo = 0;
        int length = word1.length() + word2.length();

        for (int i = 0; i < length; i++) {
            if (indexOne >= word1.length()) {
                sb.append(word2.charAt(indexTwo));
                indexTwo++;
            } else if (indexTwo >= word2.length()) {
                sb.append(word1.charAt(indexOne));
                indexOne++;
            } else {
                if (i % 2 == 0) {
                    sb.append(word1.charAt(indexOne));
                    indexOne++;                        
                } else {
                    sb.append(word2.charAt(indexTwo));
                    indexTwo++;                       
                }
            }
        }

        return sb.toString();
    }
}