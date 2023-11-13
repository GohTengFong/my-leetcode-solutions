class Solution {
    private boolean isStrong(int x, int y) {
        if (Math.abs(x - y) <= Math.min(x, y)) return true;
        else return false;
    }
    
    public int maximumStrongPairXor(int[] nums) {
        int maxXOR = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            
            for (int j = i; j < nums.length; j++) {
                int y = nums[j];
                
                int xor = x ^ y;
                
                if (isStrong(x, y) && xor > maxXOR) maxXOR = xor;
            }
        }
        
        return maxXOR;
    }
}