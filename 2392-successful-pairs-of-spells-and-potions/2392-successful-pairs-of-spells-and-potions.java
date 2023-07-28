class Solution {
    // returns the first index i where potions[i] * spell >= success
    private int binarySearch(int[] potions, int spell, long success) {
        int start = 0;
        int end = potions.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            long strength = 1l * potions[mid] * spell;

            if (strength >= success) { // recurse left
                end = mid;
            } else if (strength < success) { // recurse right
                start = mid + 1;
            }
        }

        return start;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int totalPotions = potions.length;
        int[] pairs = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int currSpell = spells[i];

            pairs[i] = totalPotions - binarySearch(potions, currSpell, success);
        }

        return pairs;
    }
}