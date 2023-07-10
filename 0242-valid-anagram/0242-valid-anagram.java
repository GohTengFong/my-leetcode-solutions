class Solution {
    public boolean isAnagram(String s, String t) {
        char[] tempS = s.toCharArray();
        char[] tempT = t.toCharArray();

        Arrays.sort(tempS);
        Arrays.sort(tempT);

        if (tempS.length != tempT.length) {
            return false;
        } else {
            for(int i = 0; i < tempS.length; i++) {
                if (tempS[i] == tempT[i]) {
                    continue;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}