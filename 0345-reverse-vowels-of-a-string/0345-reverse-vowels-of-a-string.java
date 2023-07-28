class Solution {
    private HashSet vowelSet() {
        HashSet<Character> set = new HashSet<Character>();
        char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (char vowel : vowels) {
            set.add(vowel);
        }

        return set;
    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int front = 0;
        int last = charArray.length - 1;
        HashSet<Character> vowels = vowelSet();

        while (front < last) {
            if (vowels.contains(charArray[front]) && vowels.contains(charArray[last])) {
                char temp = charArray[front];
                charArray[front] = charArray[last];
                charArray[last] = temp;

                front++;
                last--;
            }

            if (!vowels.contains(charArray[front])) front++;
            if (!vowels.contains(charArray[last])) last--;
        }

        return String.valueOf(charArray);
    }
}