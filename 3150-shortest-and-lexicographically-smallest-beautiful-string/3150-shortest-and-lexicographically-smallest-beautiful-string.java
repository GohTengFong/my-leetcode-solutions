class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        
        String answer = "";
        int shortestLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '1') {
                int numOfOnes = 1;
                
                if (numOfOnes == k) answer = s.substring(i, i + 1);
                
                for (int j = i + 1; j < charArray.length; j++) {
                    if (charArray[j] == '1') {
                        numOfOnes++;
                        
                        if (numOfOnes == k) {
                            int lengthOfWindow = j - i + 1;

                            if (lengthOfWindow < shortestLength) {
                                shortestLength = lengthOfWindow;
                                answer = s.substring(i, j + 1);
                            } else if (lengthOfWindow == shortestLength) { // must compare lexicographically
                                String temp = s.substring(i, j + 1);
                                
                                for (int l = 0; l < lengthOfWindow; l++) {
                                    if (temp.charAt(l) == '0' && answer.charAt(l) == '1') answer = temp;
                                    else if (temp.charAt(l) == '1' && answer.charAt(l) == '0') break;
                                }
                            }
                            
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}