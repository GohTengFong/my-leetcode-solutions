class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids); // sort asteroids to be able to start from smallest to largest
        double accumulatedMass = mass;

        for (int i = 0; i < asteroids.length; i++) {
            if (accumulatedMass >= asteroids[i]) {
                accumulatedMass += asteroids[i]; // mass absorbs
            } else {
                return false; // since asteroids is sorted, if mass < asteroids[i] that means that mass is smaller than all asteroids including and beyond index i, mass cannot absorb all asteroids
            }
        }

        return true; // mass can absorb all asteroids
    }
}