class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0 && n == 1) return true;
            else return false;
        }

        for (int i = flowerbed.length - 1; i >= 0; i--) {
            if (flowerbed[i] == 0) {
                if (i + 1 == flowerbed.length) {
                    if (flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                } else if (i - 1 < 0) {
                    if (flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }             
                } else {
                    if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        n--;                          
                    }
                }
            }
        }

        return n <= 0;       
    }
}