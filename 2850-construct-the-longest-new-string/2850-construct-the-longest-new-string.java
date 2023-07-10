class Solution {
    public int longestString(int x, int y, int z) {
        int count = 0;
        
        if (y > x) { // yxz
            count = count + x + x + 1 + z;
            count *= 2;
        } else if (x > y) { // zxy
            count = count + z + y + y + 1;
            count *= 2;
        } else if (x == y) { // zxy
            count = count + z + x + y;
            count *= 2;
        }
        
        return count;
    }
}