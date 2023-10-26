class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        else if (n == 0) return 1;

        long temp = n;

        if (n < 0) {
            temp = -temp;
            x = 1 / x;
        }

        if (temp % 2 == 0) {
            return myPow(x * x, (int) (temp / 2));
        } else {
            return x * myPow(x, (int) (temp - 1));
        }
    }
}