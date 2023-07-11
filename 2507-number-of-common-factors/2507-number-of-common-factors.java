class Solution {
    public int commonFactors(int a, int b) {
        int answer = 0;
        int smaller = (a < b) ? a : b;
        int larger = (a < b) ? b : a;

        for (int i = 1; i <= smaller; i++) {
            if (a % i == 0 && b % i == 0) {
                answer++;
            }
        }

        return answer;
    }
}