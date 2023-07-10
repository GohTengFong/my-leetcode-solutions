class Solution {
    public int titleToNumber(String columnTitle) {
        int count = 0;

        int power = 0;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            count += (columnTitle.charAt(i) - 64) * (Math.pow(26, power));
            power += 1;
        }

        return count;
    }
}