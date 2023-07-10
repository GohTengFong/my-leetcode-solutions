class Solution {
    private int calculateValue(int n) {
        int sum = 0;

        while (n != 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        while (!set.contains(n) && n != 1) {
            set.add(n);

            n = calculateValue(n);
        }

        return n == 1;
    }
}