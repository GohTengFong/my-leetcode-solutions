class Solution {
    private boolean flush(char[] suits) {
        char main = suits[0];

        for (int i = 0; i < suits.length; i++) {
            if (suits[i] != main) {
                return false;
            }
        }

        return true;
    }

    private int count(int[] rank) {
        int[] cards = new int[14];
        int currMax = 0;

        for (int i = 0; i < rank.length; i++) {
            cards[rank[i]] += 1;

            if (cards[rank[i]] > currMax) {
                currMax = cards[rank[i]];
            }
        }

        return currMax;
    }

    public String bestHand(int[] ranks, char[] suits) {
        if (flush(suits)) {
            return "Flush";
        }

        if (count(ranks) >= 3) {
            return "Three of a Kind";
        } else if (count(ranks) == 2) {
            return "Pair";
        }

        return "High Card";
    }
}