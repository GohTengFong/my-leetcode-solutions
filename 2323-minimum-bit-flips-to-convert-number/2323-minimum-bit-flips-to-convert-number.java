class Solution {
    public int minBitFlips(int start, int goal) {
        String current = Integer.toBinaryString(start);
        String target = Integer.toBinaryString(goal);

        // extends both binary representation into 32-bits
        String extendCurr = String.format("%32s", current).replaceAll(" ", "0");
        String extendTarget = String.format("%32s", target).replaceAll(" ", "0");

        int answer = 0;
        for (int i = 0; i < 32; i++) {
            if (extendCurr.charAt(i) != extendTarget.charAt(i)) answer++;
        }

        return answer;
    }
}