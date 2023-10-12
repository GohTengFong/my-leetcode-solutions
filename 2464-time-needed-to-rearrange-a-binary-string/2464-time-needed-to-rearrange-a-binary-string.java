class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] charArray = s.toCharArray();

        boolean hasChanges = true;
        int timer = 0;

        while (hasChanges) {
            int swapCount = 0;

            for (int i = 0; i + 1 < charArray.length;) {
                char firstChar = charArray[i];
                char secondChar = charArray[i + 1];

                if (firstChar == '0' && secondChar == '1') {
                    charArray[i] = '1';
                    charArray[i + 1] = '0';
                    swapCount++;

                    i += 2;
                } else {
                    i++;
                }
            }

            timer++;

            if (swapCount == 0) hasChanges = false;
        }

        timer--; // the last iteration is an additional iteration to check if there are any swaps

        return timer;
    }
}

/*

Idea :
- iterate through charArray
- for every "01", replace it with "10"
- increment timer after 1 entire iteration is completed
- repeat until no changes

*/