class Solution {
    private HashSet<Character> createVowelSet() {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        return vowels;
    }

    public String sortVowels(String s) {
        char[] charArray = s.toCharArray();
        HashSet<Character> validVowels = createVowelSet();
        
        ArrayList<Character> vowels = new ArrayList<Character>();
        for (char c : charArray) {
            if (validVowels.contains(c)) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);

        int vowelsIndex = 0;
        for (int i = 0; i < charArray.length; i++) {
            char currChar = charArray[i];
            
            if (validVowels.contains(currChar)) {
                charArray[i] = vowels.get(vowelsIndex);
                vowelsIndex++;
            }
        }

        return new String(charArray);
    }
}