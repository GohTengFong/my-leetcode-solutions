class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int currCount = 0;
        int vowelCount = Integer.MIN_VALUE;

        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i < k) {
                if (vowels.contains(charArray[i])) currCount++;
            } else {
                if (vowels.contains(charArray[i - k])) currCount--;
                if (vowels.contains(charArray[i])) currCount++;
            }

            if (currCount > vowelCount) vowelCount = currCount;
        }

        return vowelCount;
    }
}