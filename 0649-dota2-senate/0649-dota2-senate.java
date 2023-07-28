class Solution {
    private int checkRemaining(int index, char currSenate, ArrayList<Character> list) {
        for (int i = index; i < list.size(); i++) {
            if (list.get(i) != currSenate) return i;
        }

        for (int i = 0; i < index; i++) {
            if (list.get(i) != currSenate) return i;
        }

        return -1;
    }

    public String predictPartyVictory(String senate) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < senate.length(); i++) {
            list.add(senate.charAt(i));
        }

        int size = list.size();
        int index = 0;

        while (list.size() != 1) {
            for (int i = 0; i < size; i++) {
                if (index >= list.size()) index = 0;

                char currSenate = list.get(index);

                int first = checkRemaining(index, currSenate, list);

                if (first != -1) {
                    list.remove(first);

                    if (first < index) index--;
                } else {
                    if (currSenate == 'R') return "Radiant";
                    else return "Dire";
                }

                index++;
            }
        }

        if (list.get(0) == 'R') {
            return "Radiant";
        } else {
            return "Dire";
        }
    }
}