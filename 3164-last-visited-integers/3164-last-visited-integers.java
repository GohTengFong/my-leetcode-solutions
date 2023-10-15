class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        int prevCounter = 0;
        for (String word : words) {
            char[] charArray = word.toCharArray();
            
            if (charArray[0] != 'p') { // it is a number
                int digit = Integer.parseInt(word);
                temp.add(digit);
                
                prevCounter = 0;
            } else { // it is "prev"
                prevCounter++;
                int indexOfDesiredDigit = temp.size() - prevCounter;
                
                if (indexOfDesiredDigit < 0) answer.add(-1);
                else answer.add(temp.get(indexOfDesiredDigit));
            }
        }
        
        return answer;
    }
}